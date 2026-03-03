package com.example.ticketreservationapp;

public class RegistrationValidator {

    public boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }
}
