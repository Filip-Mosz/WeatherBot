package pl.sda.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/weatherbot?serverTimezone=Europe/Warsaw";
    private static final String USER = "weatherbot";
    private static final String PASSWORD = "weatherbot";

    public ConnectionDB() throws SQLException {
    }

    public static Connection create(){
        Connection dbConnection = null;
        try {
            dbConnection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException throwables) {
            System.out.println("Creating connection failed");
        }
        return dbConnection;
    }
}
