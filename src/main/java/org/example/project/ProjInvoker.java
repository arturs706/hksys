package org.example.project;

import java.util.ArrayList;
import java.util.List;

public class ProjInvoker {
    private List<ProjCommand> commandList = new ArrayList<>();

    public void addCommand(ProjCommand command) {
        commandList.add(command);
    }

    public void executeCommands() {
        for (ProjCommand command : commandList) {
            command.exe();
        }
        commandList.clear();
    }
}