// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.util.HashMap;
import java.util.Scanner;

public class CourseRegistration {
   public CourseRegistration() {
   }

   public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      Student var2 = new Student("Chandu", 19, 101);
      HashMap var3 = new HashMap();
      var3.put("CS101", new Course("CS101", "Java", 2));
      var3.put("CS102", new Course("CS102", "Python", 2));
      var3.put("CS103", new Course("CS103", "Data Structures", 1));

      int var4;
      do {
         System.out.println("\n===== COURSE REGISTRATION =====");
         System.out.println("1. View Courses");
         System.out.println("2. Enroll Course");
         System.out.println("3. View Registered Courses");
         System.out.println("4. Exit");
         System.out.print("Enter Choice: ");
         var4 = var1.nextInt();
         switch (var4) {
            case 1:
               System.out.println("\nAvailable Courses:");

               for(Course var6 : var3.values()) {
                  var6.display();
               }
               break;
            case 2:
               System.out.print("Enter Course ID: ");
               String var5 = var1.next().toUpperCase();
               if (var3.containsKey(var5)) {
                  try {
                     var2.enroll((Course)var3.get(var5));
                  } catch (CourseFullException var7) {
                     System.out.println(var7.getMessage());
                  }
               } else {
                  System.out.println("Invalid Course ID!");
               }
               break;
            case 3:
               var2.displayStudent();
               var2.viewCourses();
               break;
            case 4:
               System.out.println("Thank You!");
               break;
            default:
               System.out.println("Invalid Choice!");
         }
      } while(var4 != 4);

      var1.close();
   }
}
