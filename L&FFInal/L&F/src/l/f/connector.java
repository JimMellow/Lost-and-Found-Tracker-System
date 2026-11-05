package l.f;

import java.sql.*;

public class connector {

    private static final String URL =
            "jdbc:mysql://localhost:3306/LandF";

    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database Connected!");
            return conn;

        } catch (SQLException e) {
            System.out.println("Database Connection Failed!");
            System.out.println("ERROR: " + e.getMessage());
            return null;
        }
    }
}