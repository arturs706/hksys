package org.example.tasks;

import java.util.ArrayList;
import java.util.List;

public class TaskInvoker {
    private List<TaskCommand> commandList = new ArrayList<>();

    public void addCommand(TaskCommand command) {
        commandList.add(command);
    }

    public void executeCommands() {
        for (TaskCommand command : commandList) {
            command.exe();
        }
        commandList.clear();
    }
}
