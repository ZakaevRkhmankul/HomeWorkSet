package serviceImpl;

import database.Database;
import models.Group;
import models.Student;
import services.GroupService;
import services.StudentService;

import java.util.HashSet;
import java.util.Set;

public class StudentServiceImpl implements StudentService {
    private final GroupService groupService;

    public StudentServiceImpl(GroupService groupService) {
        this.groupService = groupService;
    }

    @Override
    public String addNewStudent(String groupName, Student student) {
        try {
            for (Group group : Database.groups) {
                if (group.getGroupName().equalsIgnoreCase(groupName)) {
                    if (!student.getEmail().contains("@")) {
                        throw new RuntimeException("Почтанызда @ камтылган эмес!");
                    } else if (student.getPassword().length() != 4 || !student.getPassword().matches("\\d+")) {
                        throw new Exception("Сыр соз даана 4 цифрадан турушу керек!");
                    } else if (student.getFirstName().isEmpty() && student.getLastName().isEmpty() && student.getEmail().isEmpty() && student.getPassword().isEmpty()) {
                        throw new RuntimeException("Полелердин баардыгы толтурулуш керек!");
                    } else {
                        System.out.println(group.getStudents().add(student));
                        return "Студент ийгиликтуу сакталды!";
                    }

                }
            }

        } catch (RuntimeException e) {
            return e.getMessage();
        } catch (Exception e) {
            return e.getMessage();
        }
        return null;
    }

    @Override
    public Student updateStudent(String email, String password, String newFirstName, String newLastName) {
        try {
            for (Group group : Database.groups) {
                for (Student student : group.getStudents()) {
                    if (!student.getEmail().equalsIgnoreCase(email) || !student.getPassword().equalsIgnoreCase(password)) {
                        throw new Exception("Почта же пaроль туура эмес!");
                    } else {
                        student.setFirstName(newFirstName);
                        student.setLastName(newLastName);
                        return student;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Student findStudentByFirsName(String name) {
        for (Group group : Database.groups) {
            for (Student student : group.getStudents()) {
                if (student.getFirstName().equalsIgnoreCase(name)) {
                    return student;
                }
            }
        }
        return null;
    }

    @Override
    public Set<Student> getAllStudentsByGroupName(String groupName) {
        for (Group group : Database.groups) {
            if (group.getGroupName().equalsIgnoreCase(groupName)) {
                return group.getStudents();
            }
        }
        return null;
    }

    @Override
    public String deleteStudent(String email) {
        for (Group group : Database.groups) {
            for (Student student : group.getStudents()) {
                if (student.getEmail().equalsIgnoreCase(email)) {
                    group.getStudents().remove(student);
                    return "Почтасы " + email + " болгон тудент ийгиликтуу очурулду!";
                }
            }
        }
        return "Почтасы " + email + "болгон студент табылган жок!";
    }
}
