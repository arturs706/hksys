package org.example.project;

import java.util.UUID;

public class updateStatus implements ProjCommand{
    private ProjReceiver receiver;
    private UUID projectId;

    public updateStatus(ProjReceiver receiver, UUID projectId) {
        this.receiver = receiver;
        this.projectId = projectId;
    }

    @Override
    public void exe() {
        receiver.updateStatus();
    }
}
