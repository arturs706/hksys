package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.auth.*;
import org.example.dbconn.DBConn;
import org.example.dbconn.PGImpl;
import org.example.dbconn.RefinedDBConn;
import org.example.passwordgen.HashInvoker;
import org.example.passwordgen.PasswdGen;
import org.example.project.ActionCommand;
import org.example.project.ProjInvoker;
import org.example.project.ProjReceiver;
import org.example.usercomponent.Client;
import org.example.usercomponent.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;


//pass the sql queries to the reg

public class HKManagmentSys {
    private final static String ADDPROJECT = "ADDPROJECT";
    private final static String RETRIEVEPROJECT = "RETRIEVEPROJECT";
    private final static String REMOVEPROJECT = "REMOVEPROJECT";
    private final static String EDITDESCRIPTION = "EDITDESCRIPTION";

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
//
        Client client = new Client.ClientBuilder("client@example.com", "password123")
                .contactNr("123456789")
                .build();
//
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

// Create Invoker
    ProjInvoker projectInvoker = new ProjInvoker();

// Create Receiver
    ProjReceiver receiver = new ProjReceiver();

// Create Commands using ActionCommand
    ActionCommand addProjectCommand = new ActionCommand.ActionCommandBuilder(
            receiver,
            UUID.randomUUID(),
            ADDPROJECT,
            "SQL QUERY")
            .description("Project1")
            .clientDetails(new ArrayList<>())
            .build();

    ActionCommand removeProjectCommand = new ActionCommand.ActionCommandBuilder(
            receiver,
            UUID.randomUUID(),
            REMOVEPROJECT,
            "SQL QUERY")
            .build();

    ActionCommand retrieveProjectCommand = new ActionCommand.ActionCommandBuilder(
            receiver,
            UUID.randomUUID(),
            RETRIEVEPROJECT,
            "SQL QUERY")
            .build();

    ActionCommand editDescription = new ActionCommand.ActionCommandBuilder(
            receiver,
            UUID.randomUUID(),
            EDITDESCRIPTION,
            "SQL QUERY")
            .build();
// Add commands to Invoker
        projectInvoker.addCommand(addProjectCommand);
        projectInvoker.addCommand(removeProjectCommand);
        projectInvoker.addCommand(retrieveProjectCommand);
        projectInvoker.addCommand(editDescription);

// Execute commands
        projectInvoker.executeCommands();

    }
}
