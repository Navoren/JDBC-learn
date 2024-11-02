import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Initialize the database and tables
        DatabaseInitializer.initializeDatabase();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Student Management System");
        System.out.println("1. Add Student");
        System.out.println("2. Get Student by ID");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student by ID");
        System.out.println("5. Exit");
        while (true) {
            System.out.print("\nChoose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    Student student = new Student(name, age, email);
                    student.addStudent();
                    break;

                case 2:
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    Student.getStudentById(id);
                    break;

                case 3:
                    System.out.print("Enter student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Student existingStudent = Student.getStudentById(updateId);
                    if (existingStudent != null) {
                        System.out.print("Enter new name: ");
                        existingStudent.setName(scanner.nextLine());
                        System.out.print("Enter new age: ");
                        existingStudent.setAge(scanner.nextInt());
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter new email: ");
                        existingStudent.setEmail(scanner.nextLine());
                        existingStudent.updateStudent();
                    }
                    break;

                case 4:
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    Student.deleteStudent(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
