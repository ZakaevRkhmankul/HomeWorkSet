package serviceImpl;

import database.Database;
import models.Group;
import models.Lesson;
import models.Student;
import services.GroupService;
import services.LessonService;

import java.util.List;
import java.util.Set;

public class LessonServiceImpl implements LessonService {

    private final GroupService groupService;

    public LessonServiceImpl(GroupService groupService) {
        this.groupService = groupService;
    }

    @Override
    public String addNewLessonToGroup(String groupName, Lesson lesson) {
        for (Group group : Database.groups) {
            if (group.getGroupName().equalsIgnoreCase(groupName)) {
                System.out.println(group.getLessons().add(lesson));
                return lesson.getLessonName() + " аттуу сабак ийгиликтуу сакталды!";
            }
        }
        return groupName + " аттуу группа табылган жок!";
    }

    @Override
    public Set<Lesson> getAllStudentsLesson(String email) {
        for (Group group : Database.groups) {
            for (Student student : group.getStudents()) {
                if (student.getEmail().equalsIgnoreCase(email)) {
                    return group.getLessons();

                }
            }
        }
        return null;
    }

    @Override
    public Lesson getLessonByName(String name) {
        for (Group group : Database.groups) {
            for (Lesson lesson : group.getLessons()) {
                if (lesson.getLessonName().equalsIgnoreCase(name)) {
                    return lesson;
                }
            }
        }
        return null;
    }

    @Override
    public Set<Lesson> getAllLessonByGroupName(String groupName) {
        try {
            for (Group group : Database.groups) {
                if (group.getGroupName().equalsIgnoreCase(groupName)) {
                    return group.getLessons();
                } else {
                    throw new RuntimeException(groupName + " аттуу группа табылган жок!");
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public String deleteLesson(String groupName, String name) {
        try {
            for (Group group : Database.groups) {
                if (group.getGroupName().equalsIgnoreCase(groupName)) {
                    for (Lesson lesson : group.getLessons()) {
                        if (lesson.getLessonName().equalsIgnoreCase(name)) {
                            return name + " аттуу сабак ийгиликтуу очурулду!";
                        } else {
                            throw new RuntimeException(name + " аттуу сабак табылган жок!");
                        }
                    }
                } else {
                    throw new RuntimeException(groupName + " аттуу группа табылган жок!");
                }
            }
        } catch (RuntimeException e) {
            return e.getMessage();
        }return null;
    }
}
