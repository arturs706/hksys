package org.example.project;

import java.util.UUID;

public class RemoveProjectCommand implements ProjCommand {
    private ProjReceiver receiver;
    private UUID projectId;

    public RemoveProjectCommand(ProjReceiver receiver, UUID projectId) {
        this.receiver = receiver;
        this.projectId = projectId;
    }

    @Override
    public void exe() {
        receiver.removeProject();
    }
}