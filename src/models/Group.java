package models;

import java.util.HashSet;
import java.util.Set;

public class Group {
    private Long groupId;
    private String groupName;
    private String description;
    private Set<Lesson> lessons = new HashSet<>();
    private Set<Student> students = new HashSet<>();

    public Group(){

    }

    public Group(Long groupId, String groupName, String description) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.description = description;
    }

    public Group(Long groupId, String groupName, String description, Set<Lesson>lessons, Set<Student>students){
        this.groupId = groupId;
        this.groupName = groupName;
        this.description = description;
        this.lessons = lessons;
        this.students = students;
    }
    public Long getGroupId(){
        return groupId;
    }

    public void setGroupId(Long groupId){
        this.groupId = groupId;
    }

    public String getGroupName(){
        return groupName;
    }

    public void setGroupName(String groupName){
        this.groupName = groupName;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Set<Lesson> getLessons(){
        return lessons;
    }

    public void setLessons(Set<Lesson>lessons){
        this.lessons = lessons;
    }

    public Set<Student> getStudents(){
        return students;
    }

    public void getStudents(Set<Student>students){
        this.students = students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return  "\n  Группанын ID'си:\t\t\t" + groupId +
                ",\n  Группанын аталышы: \t\t" + groupName +
                ",\n  Группанын суроттолушу:\t" + description +
                ",\n  Сабактар: \t\t\t\t" + lessons +
                ",\n  Студенттер: \t\t\t\t" + students +
                "\n  ~~~~~~~~~~~~~~~~~~~~~~~~~~";
    }
}
