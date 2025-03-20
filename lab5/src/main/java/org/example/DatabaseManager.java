package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/students_db";
    private static final String USER = "java-lab5-user";  // Ваш користувач
    private static final String PASSWORD = "";  // Ваш пароль

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Завантаження драйвера
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Помилка завантаження драйвера MySQL", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
