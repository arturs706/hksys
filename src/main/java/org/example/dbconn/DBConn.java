package org.example.dbconn;

import org.example.auth.UserType;

// Abstraction class
public abstract class DBConn {

    protected DatabaseImpl implementor;

    public DBConn(DatabaseImpl implementor) {
        this.implementor = implementor;
    }

    public abstract void connect();

    public abstract void executeQuery(String query);

    public abstract void disconnect();


}
