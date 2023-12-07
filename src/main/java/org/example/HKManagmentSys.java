package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.auth.*;
import org.example.dbconn.DBConn;
import org.example.dbconn.PGImpl;
import org.example.dbconn.RefinedDBConn;
import org.example.passwordgen.*;
import org.example.usercomponent.Client;
import java.sql.SQLException;


//pass the sql queries to the reg

public class HKManagmentSys {
    public static void main(String[] args) throws SQLException {
        Dotenv dotenv = Dotenv.configure()
                .directory("/Users/artursradionovs/Desktop/Applied Software Engineering/HKManagementSys/src/main/assets")
                .filename("env") // instead of '.env', use 'env'
                .load();

        String DATABASE_URL = dotenv.get("DATABASE_URL");
        PGImpl pgInstance = PGImpl.getInstance(DATABASE_URL);

        // Create a RefinedDBConn with the PostgreSQL implementation
        DBConn dbConn = new RefinedDBConn(pgInstance);
        Client client = new Client.ClientBuilder("client@example.com", "password123")
                .contactNr("123456789")
                .build();
        HashInvoker hashInvoker = PasswdGen.createHashInvoker();
        String resultHashedPass = hashInvoker.generateHash(client.getPasswd());

        dbConn.connect();
        AuthCommand registerCommand = RegisterCommand.create(client.getEmailAddr(), resultHashedPass, UserType.CLIENT);
        AuthInvoker invoker = new AuthInvoker();
        dbConn.executeQuery("INSERT INTO employees VALUES ('john_doe', 'password123', 'CLIENT')");
        invoker.registerUser(registerCommand);
        dbConn.disconnect();


        AuthCommand loginCommand = LoginCommand.create("john_doe", "password123");
        invoker.loginUser(loginCommand);
    }
}

