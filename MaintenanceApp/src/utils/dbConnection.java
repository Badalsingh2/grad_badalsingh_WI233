package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class dbConnection {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/test";
    private static final String USER = "postgres";
    private static final String PASSWORD = "badal159";

    private dbConnection() {} // prevent object creation

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Unable to connect to database", e);
        }
    }
}

