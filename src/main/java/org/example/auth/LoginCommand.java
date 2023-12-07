package org.example.auth;

// Concrete Command - LoginCommand
public class LoginCommand implements AuthCommand {
    private AuthManager authManager;
    private String username;
    private String password;

    // Private constructor to enforce the use of the factory method
    private LoginCommand(AuthManager authManager, String username, String password) {
        this.authManager = authManager;
        this.username = username;
        this.password = password;
    }

    // Factory method to create an instance of LoginCommand
    public static LoginCommand create(String username, String password) {
        AuthManager authManager = new AuthManager();
        return new LoginCommand(authManager, username, password);
    }


    @Override
    public void authExecute() {
        authManager.loginUser(username, password);

    }
}