package org.example.test;


public class AddProjectOperation implements ProjectOperation {

    private ProjectReceiver projReceiver;



    public AddProjectOperation(ProjectReceiver projReceiver){
        this.projReceiver = projReceiver;
    }

    @Override
    public void execute() {
        projReceiver.addProject();

    }
}