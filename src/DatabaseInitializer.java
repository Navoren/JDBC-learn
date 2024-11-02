import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseInitializer {

    // SQL statements to create database and table
    private static final String CREATE_DATABASE_SQL = "CREATE DATABASE IF NOT EXISTS school";
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS school.students (" +
            "id INT PRIMARY KEY AUTO_INCREMENT, " +
            "name VARCHAR(100), " +
            "age INT, " +
            "email VARCHAR(100) UNIQUE" +
            ")";

    // Method to initialize database and tables
    public static void initializeDatabase() {
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement()) {

            // Create the database
            stmt.executeUpdate(CREATE_DATABASE_SQL);
            System.out.println("Database created or already exists.");

            // Create the students table in the school database
            stmt.executeUpdate(CREATE_TABLE_SQL);
            System.out.println("Table created or already exists.");

        } catch (SQLException e) {
            System.err.println("Error initializing database: " + e.getMessage());
        }
    }
}
