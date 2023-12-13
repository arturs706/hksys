package org.example.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Singleton Concrete Implementor for PostgreSQL
public class PGImpl implements DatabaseImpl {

    private static PGImpl INSTANCE;
    private Connection connection;
    private String jdbcUrl;

    private PGImpl(String jdbcUrl) throws SQLException {
        this.jdbcUrl = jdbcUrl;
        try {
            this.connection = DriverManager.getConnection(jdbcUrl);
        } catch (SQLException e) {
            throw new SQLException("Error establishing PostgreSQL connection: " + e.getMessage(), e);
        }
    }

    public static PGImpl getInstance(String jdbcUrl) throws SQLException {
        // Double-checked locking for thread safety
        if (INSTANCE == null) {
            synchronized (PGImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new PGImpl(jdbcUrl);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void connect() {
        try {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Already connected to PostgreSQL database.");
            } else {
                // Implement PostgreSQL connection logic
                connection = DriverManager.getConnection(jdbcUrl);
                System.out.println("Connected to PostgreSQL database.");
            }
        } catch (SQLException e) {
            System.err.println("Error connecting to PostgreSQL database: " + e.getMessage());
        }
    }

    @Override
    public void executeQuery(String query) {
        try {
            if (connection == null || connection.isClosed()) {
                connect(); // Ensure the connection is established before executing the query
            }
            try (var statement = connection.createStatement()) {
                statement.execute(query);
                System.out.println("Executed PostgreSQL query: " + query);
            }
        } catch (SQLException e) {
            System.err.println("Error executing PostgreSQL query: " + e.getMessage());
        }
    }

    @Override
    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                // Implement PostgreSQL disconnect logic
                connection.close();
                System.out.println("Disconnected from PostgreSQL database.");
            } else {
                System.out.println("Already disconnected from PostgreSQL database.");
            }
        } catch (SQLException e) {
            System.err.println("Error disconnecting from PostgreSQL database: " + e.getMessage());
        }
    }
}
