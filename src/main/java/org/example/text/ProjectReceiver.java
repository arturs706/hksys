package org.example.text;

//The Receiver Class
public class ProjectReceiver {

    private String name;

    public ProjectReceiver(String name){
        this.name = name;
    }

    public void addProject() {
        System.out.println("Opening file " + name);
    }

    public void addClient() {
        System.out.println("Saving file " + name);
    }

    // additional text file methods (editing, writing, copying, pasting)
}
