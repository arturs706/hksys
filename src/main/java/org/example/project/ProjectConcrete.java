package org.example.project;
import java.util.Date;
import java.util.UUID;

public class ProjectConcrete {
    private UUID project_id;
    private String name;
    private String description;
    private Date start_data;
    private boolean status;

    public ProjectConcrete(UUID project_id, String name, String description, Date start_data, boolean status) {
        this.project_id = project_id;
        this.name = name;
        this.description = description;
        this.start_data = start_data;
        this.status = status;

    }
    public void addClient(){
        System.out.println("Client added");
    }
    public void removeClient(){
        System.out.println("Client removed");
    }
    public void createProject(){
        System.out.println("Project" + name + "created with id: " + project_id);
    }
    public void updateProject(){
        System.out.println("Project" + name + "with id: " + project_id + "updated");
    }
    public void getProject(){
        System.out.println("Project" + name + "with id: " + project_id + "retrieved");
    }
}
