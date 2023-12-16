package org.example.text;

//Concrete Class
public class AddProjectOperation implements ProjectCommand {

    private ProjectReceiver projectReceiver;

    @Override
    public void exe() {
        projectReceiver.addProject();
    }
}