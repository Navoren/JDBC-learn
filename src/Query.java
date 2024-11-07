public class Query {
    public static final String CREATE_DATABASE = "CREATE DATABASE IF NOT EXISTS school";
    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS school.students (" +
                                              "id INT PRIMARY KEY AUTO_INCREMENT, " +
                                              "name VARCHAR(100), " +
                                              "age INT, " +
                                              "email VARCHAR(100) UNIQUE" +
                                              ")";

    public static final String INSERT_STUDENT = "INSERT INTO school.students (name, age, email) VALUES (?, ?, ?)";
    public static final String GET_ALL_STUDENTS = "SELECT * FROM school.students";
    public static final String UPDATE_STUDENT = "UPDATE school.students SET name = ?, age = ?, email = ? WHERE id = ?";
    public static final String DELETE_STUDENT = "DELETE FROM school.students WHERE id = ?";
}
