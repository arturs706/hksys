package org.example.auth;

// Invoker
public class AuthInvoker {
    private AuthCommand authCommand;

    public void setCommand(AuthCommand authCommand) {
        this.authCommand = authCommand;
    }

    public void executeCommand() {
        authCommand.authExecute();
    }

    public void registerUser(AuthCommand registerCommand) {
        setCommand(registerCommand);
        executeCommand();
    }

    public void loginUser(AuthCommand loginCommand) {
        setCommand(loginCommand);
        executeCommand();
    }
}
