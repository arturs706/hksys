package org.example.auth;

// Concrete Command - RegisterCommand
public class RegisterCommand implements AuthCommand {
    private AuthManager authManager;
    private String email;
    private String mobilePhone;
    private String password;
    private UserType userType;

    // Private constructor to enforce the use of the factory method
    private RegisterCommand(AuthManager authManager, String email, String mobilePhone, String password, UserType userType) {
        this.authManager = authManager;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.password = password;
        this.userType = userType;
    }
//client.getEmailAddr(),
//        client.getContactNr(),
//    resultHashedPass,
//    UserType.CLIENT


    // Factory method to create an instance of RegisterCommand
    public static RegisterCommand create(String email, String mobilePhone, String password, UserType userType) {
        AuthManager authManager = new AuthManager();
        return new RegisterCommand(authManager, email, mobilePhone, password, userType);
    }


    @Override
    public void authExecute() {

        authManager.registerUser(email, mobilePhone, password, userType);
    }
}
