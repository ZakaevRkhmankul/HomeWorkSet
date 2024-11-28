package database;

public class GeneriteId {

  public static Long groupId=0L;
   public static Long groupId(){
       return ++groupId;
   }

   public static Long studentId = 0L;
   public static Long studentId(){
       return ++studentId;
   }

   public static Long lessonId = 0L;
   public static Long LessonId(){
       return ++lessonId;
   }


}
