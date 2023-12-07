package org.example.auth;

// Concrete Command - RegisterCommand
public class RegisterCommand implements AuthCommand {
    private AuthManager authManager;
    private String username;
    private String password;
    private UserType userType;

    // Private constructor to enforce the use of the factory method
    private RegisterCommand(AuthManager authManager, String username, String password, UserType userType) {
        this.authManager = authManager;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    // Factory method to create an instance of RegisterCommand
    public static RegisterCommand create(String username, String password, UserType userType) {
        AuthManager authManager = new AuthManager();
        return new RegisterCommand(authManager, username, password, userType);
    }


    @Override
    public void authExecute() {
        authManager.registerUser(username, password, userType);
    }
}
