package com.example.ticketreservationapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegistrationValidatorTest {

    private RegistrationValidator validator;

    @BeforeEach
    void setUp() {
        validator = new RegistrationValidator();
    }

    @Test
    void testValidEmailReturnsTrue() {
        assertTrue(validator.isValidPassword("validpassword123"));
    }

    @Test
    void testEmptyEmailReturnsFalse() {
        assertFalse(validator.isValidEmail(""));
        assertFalse(validator.isValidEmail(null));
    }

    @Test
    void testEmailWithoutAtSymbolReturnsFalse() {
        assertFalse(validator.isValidEmail("testemail.com"));
    }

    @Test
    void testEmailWithoutDomainReturnsFalse() {
        assertFalse(validator.isValidEmail("test@.com"));
    }

    @Test
    void testValidPasswordReturnsTrue() {
        assertTrue(validator.isValidPassword("securePassw0rd"));
    }

    @Test
    void testShortPasswordReturnsFalse() {
        assertFalse(validator.isValidPassword("12345"));
    }

    @Test
    void testPasswordExactlySixCharactersReturnsTrue() {
        assertTrue(validator.isValidPassword("123456"));
    }

    @Test
    void testNullPasswordReturnsFalse() {
        assertFalse(validator.isValidPassword(null));
    }
}