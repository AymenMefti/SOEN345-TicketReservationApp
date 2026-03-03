package com.example.ticketreservationapp;

public class LoginValidator {

    public boolean validateInput(String email, String password) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        if (password == null || password.trim().isEmpty()) {
            return false;
        }
        // Using a standard regex so it can run purely locally on the JVM without Android dependencies
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public boolean isRoleSelectionValid(boolean isAdminSelected) {
        // Admin portal is currently blocked/under construction
        //TODO This method needs to be updated when Admin is added.
        return !isAdminSelected;
    }
}