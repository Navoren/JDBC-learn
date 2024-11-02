import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
    private int id;
    private String name;
    private int age;
    private String email;

    public Student() {}

    public Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // CREATE: Add a new student to the database
    public void addStudent() {
        String sql = "INSERT INTO students (name, age, email) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, this.name);
            stmt.setInt(2, this.age);
            stmt.setString(3, this.email);
            stmt.executeUpdate();
            System.out.println("Student added successfully!");

        } catch (SQLException e) {
            System.err.println("Error adding student: " + e.getMessage());
        }
    }

    // READ: Get a student's details by ID
    public static Student getStudentById(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        Student student = null;

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                student = new Student();
                student.id = rs.getInt("id");
                student.name = rs.getString("name");
                student.age = rs.getInt("age");
                student.email = rs.getString("email");
                System.out.println("Student found: " + student.name);
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving student: " + e.getMessage());
        }
        return student;
    }

    // UPDATE: Update a student's details
    public void updateStudent() {
        String sql = "UPDATE students SET name = ?, age = ?, email = ? WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, this.name);
            stmt.setInt(2, this.age);
            stmt.setString(3, this.email);
            stmt.setInt(4, this.id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            System.err.println("Error updating student: " + e.getMessage());
        }
    }

    // DELETE: Delete a student by ID
    public static void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            System.err.println("Error deleting student: " + e.getMessage());
        }
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
