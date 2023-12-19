package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.project.ActionCommand;
import org.example.project.ProjInvoker;
import org.example.project.ProjReceiver;
import org.example.rabbitmq.RabbitMQConcrImpl;
import org.example.rabbitmq.RabbitMQImpl;
import org.example.rabbitmq.RabbitMQRefinedAbstr;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;


public class HKManagmentSys {
    private final static String ADDPROJECT = "ADDPROJECT";
    private final static String RETRIEVEPROJECT = "RETRIEVEPROJECT";
    private final static String REMOVEPROJECT = "REMOVEPROJECT";
    private final static String EDITDESCRIPTION = "EDITDESCRIPTION";
    private final static String QUEUENAME = "QUEUENAME";
    private final static String CLOUDAMQP_URL = "";

    public static void main(String[] args) throws SQLException, Exception {
        Dotenv dotenv = Dotenv.configure()
                .directory("/Users/artursradionovs/Desktop/Applied Software Engineering/HKManagementSys/src/main/assets")
                .filename("env") // instead of '.env', use 'env'
                .load();

        String DATABASE_URL = dotenv.get("DATABASE_URL");
        String CLOUDAMQP_URL = dotenv.get("CLOUDAMQP_URL");


//        PGImpl pgInstance = PGImpl.getInstance(DATABASE_URL);
//
//        // Create a RefinedDBConn with the PostgreSQL implementation
//        DBConn dbConn = new RefinedDBConn(pgInstance);
//        dbConn.connect();
////
//        Client client = new Client.ClientBuilder("client@example.com", "password123")
//                .contactNr("123456789")
//                .build();
////
//        Employee employee = new Employee.EmployeeBuilder("employee@example.com", "password123")
//                .contactNr("123456789")
//                .build();
//
//        HashInvoker hashInvoker = PasswdGen.createHashInvoker();
//        String resultHashedPass = hashInvoker.generateHash(employee.getPasswd());
//
//
//        AuthCommand registerCommand = RegisterCommand.create(
//                employee.getEmailAddr(),
//                employee.getContactNr(),
//                resultHashedPass,
//                UserType.EMPLOYEE
//        );
//        AuthInvoker invoker = new AuthInvoker();
//        String string = String.format("INSERT INTO employees VALUES ('%s', '%s', '%s', '%s')",
//                employee.getEmployeeId(),
//                employee.getEmailAddr(),
//                employee.getContactNr(),
//                resultHashedPass);
//        dbConn.executeQuery(string);
//        invoker.registerUser(registerCommand);
//        dbConn.disconnect();
//        AuthCommand loginCommand = LoginCommand.create("john_doe", "password123");
//        invoker.loginUser(loginCommand);
//

        RabbitMQImpl implementor = new RabbitMQConcrImpl();
        RabbitMQRefinedAbstr refinedAbstr = new RabbitMQRefinedAbstr(implementor, CLOUDAMQP_URL, QUEUENAME);
        refinedAbstr.sendMessage("Hello world");
        refinedAbstr.getMessage();


        ProjInvoker projectInvoker = new ProjInvoker();
        ProjReceiver receiver = new ProjReceiver();

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

        projectInvoker.addCommand(addProjectCommand);
        projectInvoker.addCommand(removeProjectCommand);
        projectInvoker.addCommand(retrieveProjectCommand);
        projectInvoker.addCommand(editDescription);
        projectInvoker.executeCommands();

    }
}
