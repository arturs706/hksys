package org.example.milestones;

import org.example.milestones.MilestoneCommand;
import java.util.ArrayList;
import java.util.List;

public class MilestoneInvoker {
    private List<MilestoneCommand> commandList = new ArrayList<>();

    public void addCommand(MilestoneCommand command) {
        commandList.add(command);
    }

    public void executeCommands() {
        for (MilestoneCommand command : commandList) {
            command.exe();
        }
        commandList.clear();
    }
}
