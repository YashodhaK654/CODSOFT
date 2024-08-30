import java.util.ArrayList;
import java.util.Scanner;

class Course {
    private String courseName;
    private String courseCode;

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    @Override
    public String toString() {
        return courseCode + ": " + courseName;
    }
}

class Student {
    private String name;
    private String studentId;
    private ArrayList<Course> registeredCourses;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.registeredCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
    }

    public void displayRegisteredCourses() {
        System.out.println("Courses registered by " + name + ":");
        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered.");
        } else {
            for (Course course : registeredCourses) {
                System.out.println(course);
            }
        }
    }
}

public class CourseRegistrationSystem {
    private static ArrayList<Course> availableCourses = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeCourses();
        int choice;

        do {
            System.out.println("\n===== Course Registration System =====");
            System.out.println("1. Register Student");
            System.out.println("2. Register Course for Student");
            System.out.println("3. Display Student Information");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerStudent();
                    break;
                case 2:
                    registerCourseForStudent();
                    break;
                case 3:
                    displayStudentInformation();
                    break;
                case 4:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);
    }

    private static void initializeCourses() {
        availableCourses.add(new Course("Mathematics", "MATH101"));
        availableCourses.add(new Course("Physics", "PHYS101"));
        availableCourses.add(new Course("Chemistry", "CHEM101"));
        availableCourses.add(new Course("Computer Science", "CS101"));
    }

    private static void registerStudent() {
        System.out.print("Enter Student Name: ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine();
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        Student student = new Student(name, studentId);
        students.add(student);
        System.out.println("Student registered successfully!");
    }

    private static void registerCourseForStudent() {
        System.out.print("Enter Student ID: ");
        scanner.nextLine(); // Consume newline
        String studentId = scanner.nextLine();

        Student student = findStudentById(studentId);

        if (student != null) {
            System.out.println("Available Courses:");
            for (int i = 0; i < availableCourses.size(); i++) {
                System.out.println((i + 1) + ". " + availableCourses.get(i));
            }

            System.out.print("Choose a course to register (enter the number): ");
            int courseChoice = scanner.nextInt();

            if (courseChoice >= 1 && courseChoice <= availableCourses.size()) {
                Course course = availableCourses.get(courseChoice - 1);
                student.registerCourse(course);
                System.out.println("Course registered successfully!");
            } else {
                System.out.println("Invalid course selection.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void displayStudentInformation() {
        System.out.print("Enter Student ID: ");
        scanner.nextLine(); // Consume newline
        String studentId = scanner.nextLine();

        Student student = findStudentById(studentId);

        if (student != null) {
            System.out.println("Student Name: " + student.getName());
            System.out.println("Student ID: " + student.getStudentId());
            student.displayRegisteredCourses();
        } else {
            System.out.println("Student not found.");
        }
    }

    private static Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
}
