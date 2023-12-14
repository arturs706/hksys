package org.example.project;


public class EditDescription implements ProjCommand {
    private ProjReceiver receiver;
    private String description;

    public EditDescription(ProjReceiver receiver, String description) {
        this.receiver = receiver;
        this.description = description;
    }

    @Override
    public void exe(){

        receiver.editDescription();
    }

}

