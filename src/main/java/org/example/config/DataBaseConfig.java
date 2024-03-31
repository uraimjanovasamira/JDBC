package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConfig {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String name = "postgres";
    protected static final String password = "sami";

    public static Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, name, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return connection;
    }

}
