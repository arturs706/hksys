package org.example.auth;

// Receiver
public class AuthManager {
    public void registerUser(String username, String mobilePhone, String password, UserType userType) {
        // Logic for user registration
        System.out.println("User registered: " + username + ", UserType: " + userType);
    }

    public void loginUser(String username, String password) {
        // Logic for user login
        System.out.println("User logged in: " + username);
    }
}