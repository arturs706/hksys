package org.example.text;

//Concrete Class

public class AddClientOperation implements ProjectCommand {

    private ProjectReceiver projectReceiver;

    // constructors

    @Override
    public void exe() {
        projectReceiver.addClient();
    }
}