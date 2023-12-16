package org.example;


import org.example.test.ProjectReceiver;
import org.example.text.ProjectOperationExecutor;


public class HKManagmentSys {
    public static void main(String[] args) {

        ProjectOperationExecutor projectOperationExecutor
                = new ProjectOperationExecutor();
        //RECEIVER == RECEIVER
        ProjectReceiver receiver = new ProjectReceiver();
        //INVOKER.
        projectOperationExecutor.executeOperation(receiver::addProject);
        projectOperationExecutor.executeOperation(receiver::addClient);

    }
}
