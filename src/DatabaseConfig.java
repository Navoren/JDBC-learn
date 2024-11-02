import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {
    private static String DB_URL;
    private static String USER;
    private static String PASSWORD;

    static {
        try (InputStream input = DatabaseConfig.class.getClassLoader().getResourceAsStream("db.properties")) {
            Properties prop = new Properties();
            if (input != null) {
                prop.load(input);
                DB_URL = prop.getProperty("DB_URL");
                USER = prop.getProperty("DB_USER");
                PASSWORD = prop.getProperty("DB_PASSWORD");
            } else {
                System.err.println("Sorry, unable to find db.properties");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (DB_URL == null || USER == null || PASSWORD == null) {
            throw new IllegalStateException("Database credentials are not initialized properly.");
        }
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }
}
