import java.util.List;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentDAO studentDAO = new StudentDAO();

    public static void main(String[] args) {
        // Initialize the database and table
        DatabaseInitializer.initializeDatabase();
        
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character after integer input

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    // Display menu options
    private static void displayMenu() {
        System.out.println("\n--- Student Management System ---");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    // Add a new student
    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline character after integer input

        System.out.print("Enter student email: ");
        String email = scanner.nextLine();

        studentDAO.addStudent(name, age, email);
    }

    // View all students
    private static void viewAllStudents() {
        List<Student> students = studentDAO.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\n--- List of Students ---");
            students.forEach(System.out::println);
        }
    }

    // Update student information
    private static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character after integer input

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline character after integer input

        System.out.print("Enter new email: ");
        String email = scanner.nextLine();

        studentDAO.updateStudent(id, name, age, email);
    }

    // Delete a student by ID
    private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character after integer input

        studentDAO.deleteStudent(id);
    }
}
