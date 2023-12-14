package org.example.project;

import javax.sound.sampled.Port;
import java.util.UUID;

public class removeClient implements ProjCommand {
    private ProjReceiver receiver;
    private UUID projectId;

    public removeClient(ProjReceiver receiver, UUID projectId) {
        this.receiver = receiver;
        this.projectId = projectId;
    }

    @Override
    public void exe() {
        receiver.removeClient();
    }
}
