package org.example.project;


import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;


    public class AddProjectCommand implements ProjCommand {
        private ProjReceiver receiver;
        private String name;
        private String description;
        private Date startDate;
        private String status;
        private ArrayList<UUID> clients;
        private ArrayList<UUID> team;

        public AddProjectCommand(ProjReceiver receiver, String name, String description, Date startDate, String status, ArrayList<UUID> clients, ArrayList<UUID> team) {
            this.receiver = receiver;
            this.name = name;
            this.description = description;
            this.startDate = startDate;
            this.status = status;
            this.clients = clients;
            this.team = team;
        }

        @Override
        public void exe(){
            receiver.addProject();
        }

    }

