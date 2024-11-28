package models;

public class Lesson {
    private Long lessonId;
    private String lessonName;
    private String taskDescription;

    public Lesson() {
    }

    public Lesson(Long lessonId, String lessonName, String taskDescription) {
        this.lessonId = lessonId;
        this.lessonName = lessonName;
        this.taskDescription = taskDescription;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonId=" + lessonId +
                ", lessonName='" + lessonName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                '}';
    }
}
