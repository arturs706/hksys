package org.example.dbconn;

// Implementor interface
public interface DatabaseImpl {
    void connect();
    void executeQuery(String query);
    void disconnect();
}