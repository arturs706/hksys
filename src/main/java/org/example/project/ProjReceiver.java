package org.example.project;

import java.util.List;
import java.util.UUID;

public class ProjReceiver {

    public void executeCommand(String action, UUID projectId, String description, List<String> clientDetails, String sqlQuery) {
        switch (action) {
            case "AddProject":
                addProject();
                break;
            case "RemoveProject":
                removeProject();
                break;
            case "RetrieveProject":
                retrieveProject();
                break;
            case "EditDescription":
                editDescription();
                break;
            default:
                System.out.println("Invalid action");
        }
    }

    private void addProject() {
        System.out.println("Add project");
        // Additional logic for adding a project
    }

    private void removeProject() {
        System.out.println("Remove project");
        // Additional logic for removing a project
    }

    private void retrieveProject() {
        System.out.println("Retrieve project");
        // Additional logic for retrieving a project
    }
    private void editDescription() {
        System.out.println("Edit description");

    }
}
