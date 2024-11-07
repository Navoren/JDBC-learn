public class App {
    public static void main(String[] args) {
        // Initialize the database and table
        DatabaseInitializer.initializeDatabase();

        StudentDAO studentDAO = new StudentDAO();

        // Add a new student
        studentDAO.addStudent("John Doe", 20, "john.doe@example.com");

        // Retrieve and print all students
        studentDAO.getAllStudents().forEach(System.out::println);

        // Update a student's information
        studentDAO.updateStudent(1, "Jane Doe", 21, "jane.doe@example.com");

        // Delete a student
        studentDAO.deleteStudent(1);
    }
}
