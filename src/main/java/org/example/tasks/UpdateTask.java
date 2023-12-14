package org.example.tasks;

import java.util.UUID;

public class UpdateTask implements TaskCommand {
    private TaskReceiver taskReceiver;
    private UUID projectId;

    public UpdateTask(TaskReceiver taskReceiver, UUID projectId) {
        this.taskReceiver = taskReceiver;
        this.projectId = projectId;
    }

    @Override
    public void exe() {
        taskReceiver.updateTaskStatus();
    }
}
