package org.example.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Singleton Concrete Implementor for PostgreSQL
public class PGImpl implements DatabaseImpl {

    private static PGImpl INSTANCE;
    private Connection connection;

    private PGImpl(String jdbcUrl) throws SQLException {
        try {
            this.connection = DriverManager.getConnection(jdbcUrl);
        } catch (SQLException e) {
            throw new SQLException("Error establishing PostgreSQL connection: " + e.getMessage(), e);
        }
    }

    public static synchronized PGImpl getInstance(String jdbcUrl) throws SQLException {
        // Ensuring thread-safe creation of the singleton instance
        if (INSTANCE == null) {
            INSTANCE = new PGImpl(jdbcUrl);
        }
        return INSTANCE;
    }

    @Override
    public void connect() {
        // Implement PostgreSQL connect logic
        System.out.println("Connecting to PostgreSQL database...");
    }

    @Override
    public void executeQuery(String query) {
        // Implement PostgreSQL query execution logic
        System.out.println("Executing PostgreSQL query: " + query);
    }

    @Override
    public void disconnect() {
        // Implement PostgreSQL disconnect logic
        System.out.println("Disconnecting from PostgreSQL database...");
    }
}
