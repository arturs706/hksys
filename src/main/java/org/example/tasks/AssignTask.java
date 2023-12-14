package org.example.tasks;

public class AssignTask implements TaskCommand {
    private TaskReceiver taskReceiver;
    @Override
    public void exe() {
        taskReceiver.assignTask();
    }
}
