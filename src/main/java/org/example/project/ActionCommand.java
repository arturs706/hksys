package org.example.project;


import org.example.project.ProjCommand;
import org.example.project.ProjReceiver;
import java.util.List;
import java.util.UUID;

public class ActionCommand implements ProjCommand {
    private ProjReceiver receiver;
    private String action;
    private UUID projectId;
    private String description;
    private List<String> clientDetails;
    private String SQLQuery;


    // Private constructor to enforce the use of the builder
    private ActionCommand(ProjReceiver receiver, String action, UUID projectId, String description, List<String> clientDetails, String SQLQuery) {
        this.receiver = receiver;
        this.action = action;
        this.projectId = projectId;
        this.SQLQuery = SQLQuery;
        this.description = description;
        this.clientDetails = clientDetails;
    }

    @Override
    public void execute() {
        receiver.executeCommand(action, projectId, description, clientDetails, SQLQuery);
    }

    // Builder class for ActionCommand
    public static class ActionCommandBuilder {
        private String SQLQuery;
        private ProjReceiver receiver;
        private String action;
        private UUID projectId;
        private String description;
        private List<String> clientDetails;

        public ActionCommandBuilder(ProjReceiver receiver, String action, String SQLQuery) {
            this.receiver = receiver;
            this.action = action;
            this.SQLQuery = SQLQuery;
        }

        public ActionCommandBuilder projectId(UUID projectId) {
            this.projectId = projectId;
            return this;
        }

        public ActionCommandBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ActionCommandBuilder clientDetails(List<String> clientDetails) {
            this.clientDetails = clientDetails;
            return this;
        }

        public ActionCommand build() {
            // Validate that required fields are set if needed
            // For simplicity, we assume all fields are required here
            validateFields();
            return new ActionCommand(receiver, action, projectId, description, clientDetails, SQLQuery);
        }

        private void validateFields() {
            // You can add validation logic here if necessary
            // For example, check that required fields are not null
            if (action == null || projectId == null) {
                throw new IllegalStateException("Action and projectId are required.");
            }
        }
    }
}
