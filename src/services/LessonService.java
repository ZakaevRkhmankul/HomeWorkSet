package services;

import models.Lesson;

import java.util.List;
import java.util.Set;

public interface LessonService {
    String addNewLessonToGroup(String groupName,Lesson lesson);

    Set<Lesson> getAllStudentsLesson(String email);

    Lesson getLessonByName(String name);

    Set<Lesson>getAllLessonByGroupName( String groupName);

    String deleteLesson(String groupName,String name);
}
