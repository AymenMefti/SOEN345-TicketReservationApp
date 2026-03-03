package com.example.ticketreservationapp;

public class RegistrationValidator {

    // A standard email regex that works on any Java environment
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-z]{2,}$";

    public boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return email.matches(EMAIL_REGEX);
    }

    public boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }
}