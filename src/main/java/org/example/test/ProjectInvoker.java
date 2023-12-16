package org.example.test;

import java.util.ArrayList;
import java.util.List;

public class ProjectInvoker {

    private final List<AddProjectOperation> addProjectOperations = new ArrayList<>();

    public void executeOperation(AddProjectOperation addProjectOperation) {
        addProjectOperations.add(addProjectOperation);
        addProjectOperation.execute();
    }
}