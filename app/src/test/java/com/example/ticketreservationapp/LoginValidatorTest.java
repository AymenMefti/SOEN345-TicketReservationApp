package com.example.ticketreservationapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoginValidatorTest {

    private LoginValidator validator;

    @BeforeEach
    void setUp() {
        validator = new LoginValidator();
    }

    // Input Validation Tests

    @Test
    void testValidEmailAndPasswordReturnsTrue() {
        assertTrue(validator.validateInput("user@student.concordia.ca", "securePassword123"));
    }

    @Test
    void testEmptyEmailReturnsFalse() {
        assertFalse(validator.validateInput("", "password123"));
        assertFalse(validator.validateInput("   ", "password123"));
    }

    @Test
    void testNullEmailReturnsFalse() {
        assertFalse(validator.validateInput(null, "password123"));
    }

    @Test
    void testInvalidEmailFormatReturnsFalse() {
        assertFalse(validator.validateInput("userdomain.com", "password123")); // Missing @
        assertFalse(validator.validateInput("user@", "password123")); // Missing domain
    }

    @Test
    void testEmptyPasswordReturnsFalse() {
        assertFalse(validator.validateInput("user@example.com", ""));
        assertFalse(validator.validateInput("user@example.com", "   "));
    }

    @Test
    void testNullPasswordReturnsFalse() {
        assertFalse(validator.validateInput("user@example.com", null));
    }

    // Business Logic / Role Selection Tests

    @Test
    void testAdminRoleIsBlocked() {
        // The boolean represents 'isAdminSelected'. True should return false (blocked).
        //TODO This test needs to be removed and updated when Admin is added.
        assertFalse(validator.isRoleSelectionValid(true));
    }

    @Test
    void testCustomerRoleIsAllowed() {
        // False represents a standard customer. Should return true (allowed).
        assertTrue(validator.isRoleSelectionValid(false));
    }
}