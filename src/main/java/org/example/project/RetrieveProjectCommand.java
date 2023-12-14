package org.example.project;

import java.util.UUID;

public class RetrieveProjectCommand implements ProjCommand {
    private ProjReceiver receiver;
    private UUID projectId;

    public RetrieveProjectCommand(ProjReceiver receiver, UUID projectId) {
        this.receiver = receiver;
        this.projectId = projectId;
    }

    @Override
    public void exe() {
        receiver.retrieveProject();
    }
}