import java.util.ArrayList;

class Student extends Person implements Enrollable {
   int rollNo;
   ArrayList<Course> enrolledCourses = new ArrayList();

   Student(String var1, int var2, int var3) {
      super(var1, var2);
      this.rollNo = var3;
   }

   public void enroll(Course var1) throws CourseFullException {
      if (var1.currentSeats >= var1.maxSeats) {
         throw new CourseFullException("Course is Full!");
      } else {
         this.enrolledCourses.add(var1);
         ++var1.currentSeats;
         System.out.println("Enrolled in " + var1.name);
      }
   }

   void displayStudent() {
      System.out.println("\nName : " + this.name);
      System.out.println("Age : " + this.age);
      System.out.println("Roll No : " + this.rollNo);
   }

   void viewCourses() {
      if (this.enrolledCourses.isEmpty()) {
         System.out.println("No courses enrolled.");
      } else {
         System.out.println("\nEnrolled Courses:");

         for(Course var2 : this.enrolledCourses) {
            System.out.println(var2.id + " - " + var2.name);
         }

      }
   }
}