
package com.library.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/lib_db";
    private static final String USER = "root";
    private static final String PASSWORD = "#Ganesh1386";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("Database connection failed", e);
        }
    }
}
