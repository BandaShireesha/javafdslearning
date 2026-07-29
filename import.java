import java.util.*;

// Interface
interface Enrollable {
    void enroll(Course c) throws CourseFullException;
}

// Custom Exception
class CourseFullException extends Exception {
    public CourseFullException(String msg) {
        super(msg);
    }
}

// Base Class
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// Course Class
class Course {
    String id, name;
    int maxSeats, currentSeats;

    Course(String id, String name, int maxSeats) {
        this.id = id;
        this.name = name;
        this.maxSeats = maxSeats;
        this.currentSeats = 0;
    }

    void display() {
        System.out.println(id + " - " + name +
                " | Seats: " + currentSeats + "/" + maxSeats);
    }
}

// Student Class
class Student extends Person implements Enrollable {

    int rollNo;
    ArrayList<Course> enrolledCourses = new ArrayList<>();

    Student(String name, int age, int rollNo) {
        super(name, age);
        this.rollNo = rollNo;
    }

    public void enroll(Course c) throws CourseFullException {

        if (c.currentSeats >= c.maxSeats)
            throw new CourseFullException("Course is Full!");

        enrolledCourses.add(c);
        c.currentSeats++;

        System.out.println("Enrolled in " + c.name);
    }

    void displayStudent() {
        System.out.println("\nName : " + name);
        System.out.println("Age : " + age);
        System.out.println("Roll No : " + rollNo);
    }

    void viewCourses() {
        if (enrolledCourses.isEmpty()) {
            System.out.println("No courses enrolled.");
            return;
        }

        System.out.println("\nEnrolled Courses:");
        for (Course c : enrolledCourses) {
            System.out.println(c.id + " - " + c.name);
        }
    }
}

// Main Class
public class CourseRegistration {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Student s = new Student("Chandu", 19, 101);

        HashMap<String, Course> courses = new HashMap<>();

        courses.put("CS101", new Course("CS101", "Java", 2));
        courses.put("CS102", new Course("CS102", "Python", 2));
        courses.put("CS103", new Course("CS103", "Data Structures", 1));

        int choice;

        do {

            System.out.println("\n===== COURSE REGISTRATION =====");
            System.out.println("1. View Courses");
            System.out.println("2. Enroll Course");
            System.out.println("3. View Registered Courses");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Courses:");
                    for (Course c : courses.values())
                        c.display();
                    break;

                case 2:
                    System.out.print("Enter Course ID: ");
                    String id = sc.next().toUpperCase();

                    if (courses.containsKey(id)) {
                        try {
                            s.enroll(courses.get(id));
                        } catch (CourseFullException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Invalid Course ID!");
                    }
                    break;

                case 3:
                    s.displayStudent();
                    s.viewCourses();
                    break;

                case 4:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}