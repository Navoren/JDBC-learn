import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseInitializer {
    public static void initializeDatabase() {
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(Query.CREATE_DATABASE);
            System.out.println("Database created or already exists.");

            stmt.executeUpdate(Query.CREATE_TABLE);
            System.out.println("Table created or already exists.");

        } catch (SQLException e) {
            System.err.println("Error initializing database: " + e.getMessage());
        }
    }
}
