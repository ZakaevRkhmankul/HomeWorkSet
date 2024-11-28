import database.Database;
import database.GeneriteId;
import enums.Gender;
import models.Group;
import models.Lesson;
import models.Student;
import serviceImpl.GroupServiceImpl;
import serviceImpl.LessonServiceImpl;
import serviceImpl.StudentServiceImpl;
import services.GroupService;
import services.LessonService;
import services.StudentService;

import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        GroupService groupService = new GroupServiceImpl();
        StudentService studentService = new StudentServiceImpl(groupService);
        LessonService lessonService = new LessonServiceImpl(groupService);

        LocalTime localTime = LocalTime.now();
        int localTameHour = LocalTime.now().getHour();
        int localTameMinute = LocalTime.now().getMinute();
        if (localTameHour >= 5 && localTameHour <= 12) {
            System.out.println("Кутман тан! " + localTameHour + ":" + localTameMinute + "\n");
        } else if (localTameHour > 12 && localTameHour < 17) {
            System.out.println("Кутман кун! " + localTameHour + ":" + localTameMinute + "\n");
        } else if (localTameHour >= 17 && localTameHour <= 24) {
            System.out.println("Кутман кеч! " + localTameHour + ":" + localTameMinute + "\n");
        } else {
            System.out.println("Кутман тун!" + localTameHour + ":" + localTameMinute + "\n");
        }


        while (true) {
            try {
                System.out.println("""
                        1  -> Add new group
                        2  -> Get group by name
                        3  -> Update group name
                        4  -> Get all groups
                        5  -> Add new student to group
                        6  -> Update student
                        7  -> Find student by first name
                        8  -> Get all students by group name
                        9  -> Get all student's lesson
                        10 -> Delete student
                        11 -> Add new lesson to group
                        12 -> Get lesson by name
                        13 -> Get all lesson by group name
                        14 -> Delete lesson
                        15 -> Delete group
                        """);
                System.out.print("Вариант танданыз: ");
                int choice = scanner1.nextInt();
                if (choice <= 0) {
                    throw new RuntimeException(choice + ", мындай вариант жок, туура жазыныз!");
                }
                scanner1.nextLine();
                switch (choice) {
                    case 1 -> {
                        System.out.print("Жаны группага ат жазыныз: ");
                        String groupName = scanner2.nextLine();
                        System.out.print("Группанын суроттомосун жазыныз: ");
                        String description = scanner2.nextLine();
                        System.out.println(groupService.addNewGroup(new Group(GeneriteId.groupId(), groupName, description)));
                    }
                    case 2 -> {
                        System.out.print("Группанын атын жазыныз: ");
                        String groupName = scanner2.nextLine();
                        System.out.println(groupService.getGroupByName(groupName));
                    }
                    case 3 -> {
                        System.out.print("Группанын атын жазыныз: ");
                        String groupName = scanner2.nextLine();
                        System.out.print("Жаны ат жазыныз: ");
                        String newName = scanner2.nextLine();
                        System.out.println(groupService.updateGroupName(groupName, newName));
                    }
                    case 4 -> {
                        System.out.println(groupService.getAllGroups());
                    }
                    case 5 -> {
                        System.out.print("Кайсы группага студент кошууну каалайсыз, ошол группанын атын жазыныз: ");
                        String groupName = scanner2.nextLine();
                        System.out.print("Студенттин атын жазыныз: ");
                        String studentName = scanner2.nextLine();
                        System.out.print("Фамилиясын жазыныз: ");
                        String studentsLastName = scanner2.nextLine();
                        System.out.print("Электрондук почтасын жазыныз: ");
                        String gmail = scanner2.nextLine();
                        System.out.print("Пароль ойлоп табыныз(узундугу 4 символдон аз болбошу керек): ");
                        String password = scanner2.nextLine();
                        System.out.print("Жынысын жазыныз: ");
                        String gender = scanner2.nextLine();

                        if (gender.equalsIgnoreCase("male")) {
                            System.out.println(studentService.addNewStudent(groupName, new Student(GeneriteId.studentId(), studentName, studentsLastName, gmail, password, Gender.MALE)));
                        } else if (gender.equalsIgnoreCase("female")) {
                            System.out.println(studentService.addNewStudent(groupName, new Student(GeneriteId.studentId(), studentName, studentsLastName, gmail, password, Gender.FEMALE)));
                        } else {
                            System.out.println("Туура эмес!");
                        }
                    }
                    case 6 -> {
                        System.out.print("Почтанызды жазыныз: ");
                        String email = scanner2.nextLine();
                        System.out.print("Пароль жазыныз: ");
                        String password = scanner2.nextLine();

                        System.out.print("Жаны ат жазыныз:");
                        String newName = scanner2.nextLine();
                        System.out.print("Жаны фамилия жазыныз:");
                        String newFirstName = scanner2.nextLine();
                        System.out.println(studentService.updateStudent(email, password, newName, newFirstName));
                    }
                    case 7 ->{
                        System.out.print("Студенттин атын жазыныз: ");
                        String studentName = scanner2.nextLine();
                        System.out.println(studentService.findStudentByFirsName(studentName));
                    }
                    case 8 -> {
                        System.out.print("Группанын атын жазыныз:");
                        String groupName = scanner2.nextLine();
                        System.out.println(studentService.getAllStudentsByGroupName(groupName));
                    }
                    case 9 -> {
                        System.out.print("Студенттин почтасын жазыныз:");
                        String studentsEmail = scanner2.nextLine();
                        System.out.println(lessonService.getAllStudentsLesson(studentsEmail));
                    }
                    case 10 -> {
                        System.out.print("Кимди очуросуз, ошол адамдын почтасын жазыныз:");
                        String email = scanner2.nextLine();
                        System.out.println(studentService.deleteStudent(email));
                    }
                    case 11 -> {
                        System.out.print("Группанын атын жазыныз: ");
                        String groupName = scanner2.nextLine();
                        System.out.print("Сабактын атын жазыныз: ");
                        String lessonName = scanner2.nextLine();
                        System.out.print("Сабактын суроттомосун жазыныз: ");
                        String taskDescription = scanner2.nextLine();
                        System.out.println(lessonService.addNewLessonToGroup(groupName, new Lesson(GeneriteId.LessonId(),lessonName,taskDescription)));
                    }
                    case 12 -> {
                        System.out.print("Сабактын атын жазыныз:");
                        String lessonName = scanner2.nextLine();
                        System.out.println(lessonService.getLessonByName(lessonName));
                    }
                    case 13 ->{
                        System.out.print("Группанын атын жазыныз:");
                        String groupName = scanner2.nextLine();
                        lessonService.getAllLessonByGroupName(groupName);
                    }
                    case 14 ->{
                        System.out.print("Группанын атын жазыныз:");
                        String groupName = scanner2.nextLine();
                        System.out.print("Сабактын атын жазыныз:");
                        String lessonName = scanner2.nextLine();
                        System.out.println(lessonService.deleteLesson(groupName, lessonName));
                    }
                    case 15 ->{
                        System.out.print("Группанын атын жазыныз:");
                        String groupName = scanner2.nextLine();
                        System.out.println(groupService.deleteGroup(groupName));
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("error");
                scanner1.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}