package org.example.project;

import java.util.ArrayList;
import java.util.UUID;

public class addClient implements ProjCommand{
    private ProjReceiver receiver;
    private String name;
    private ArrayList<UUID> clients;

    public addClient(ProjReceiver receiver, String name, ArrayList<UUID> clients) {
        this.receiver = receiver;
        this.name = name;
        this.clients = clients;
    }

    @Override
    public void exe(){
        receiver.addClient();
    }
}
