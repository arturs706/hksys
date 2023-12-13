package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.auth.*;
import org.example.dbconn.DBConn;
import org.example.dbconn.PGImpl;
import org.example.dbconn.RefinedDBConn;
import org.example.passwordgen.*;
import org.example.usercomponent.Client;
import org.example.usercomponent.Employee;
import java.sql.SQLException;
import java.util.UUID;


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
        dbConn.connect();

        Client client = new Client.ClientBuilder("client@example.com", "password123")
                .contactNr("123456789")
                .build();

        Employee employee = new Employee.EmployeeBuilder("employee@example.com", "password123")
                .contactNr("123456789")
                .build();

        HashInvoker hashInvoker = PasswdGen.createHashInvoker();
        String resultHashedPass = hashInvoker.generateHash(employee.getPasswd());


        AuthCommand registerCommand = RegisterCommand.create(
                employee.getEmailAddr(),
                employee.getContactNr(),
                resultHashedPass,
                UserType.EMPLOYEE
        );
        AuthInvoker invoker = new AuthInvoker();
        String string = String.format("INSERT INTO employees VALUES ('%s', '%s', '%s', '%s')",
                employee.getEmployeeId(),
                employee.getEmailAddr(),
                employee.getContactNr(),
                resultHashedPass);
        dbConn.executeQuery(string);
        invoker.registerUser(registerCommand);
        dbConn.disconnect();
        AuthCommand loginCommand = LoginCommand.create("john_doe", "password123");
        invoker.loginUser(loginCommand);
    }
}
