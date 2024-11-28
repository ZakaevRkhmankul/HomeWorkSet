package services;

import models.Group;
import models.Student;

import java.util.Set;

public interface StudentService {
    String addNewStudent(String groupName, Student student);

    Student updateStudent(String email, String password, String newFirstName, String newLastName);

    Student findStudentByFirsName(String name);

    Set<Student> getAllStudentsByGroupName(String groupName);

    String deleteStudent(String email);
}
