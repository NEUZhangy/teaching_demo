package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {

    @Test
    void testIsValidPassword() {
        User userWithCorrectPassword = new User();
        userWithCorrectPassword.setPassword(Integer.parseInt("correct_password"));

        User userWithIncorrectPassword = new User();
        userWithIncorrectPassword.setPassword(1234);

        assertTrue(LoginController.isValidPwd(123));
        assertFalse(LoginController.isValidPwd(1234));
    }

    @Test
    void login() {
    }

    @Test
    void checkUser01() {
    }

    @Test
    void checkPassword02() {


    }
}