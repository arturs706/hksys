package org.example.text;

import org.example.test.ProjectOperation;
import java.util.ArrayList;
import java.util.List;


//Invoker Class
public class ProjectOperationExecutor {

    private final List<ProjectCommand> projectCommands
            = new ArrayList<>();

    public void executeOperation(ProjectCommand projectCommand) {
        projectCommands.add(projectCommand);
        projectCommand.exe();
    }
}