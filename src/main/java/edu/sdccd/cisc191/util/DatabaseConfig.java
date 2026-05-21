package edu.sdccd.cisc191.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final String URL = "jdbc:h2:./data/studentdb";

    public static Connection getConnection() throws SQLException {
<<<<<<< HEAD
        // TODO return a DriverManager connection
        return DriverManager.getConnection(URL);
=======
        return DriverManager.getConnection(URL, "sa", "");
>>>>>>> 9105828dd9b915bbcff480e9b6d64c098fe7392a
    }
}