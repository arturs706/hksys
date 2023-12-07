package org.example.dbconn;


// RefinedAbstraction class
public class RefinedDBConn extends DBConn{

    public RefinedDBConn(DatabaseImpl implementor) {
        super(implementor);
    }

    @Override
    public void connect() {
        implementor.connect();
    }

    @Override
    public void executeQuery(String query) {
        implementor.executeQuery(query);
    }

    @Override
    public void disconnect() {
        implementor.disconnect();
    }
}
