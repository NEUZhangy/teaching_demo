package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {
    Database db = new Database();
    @Test
    void testIsValidPassword() {
        assertFalse(LoginController.isValidPwd(123));
        assertTrue(LoginController.isValidPwd(123456));
        assertFalse(LoginController.isValidPwd(11111111));
    }

    @Test
    void login() {
        LoginController controller = new LoginController(db);
        User user = new User("admin", 123);
        String result = controller.login(user);
        assertEquals("{\"result\": \"Login successful\"}", result);
    }

    @Test
    void checkUser01() {
        LoginController controller = new LoginController(db);
        User user = new User("admin", 123);
        assertTrue(controller.checkUser01(user));
    }

    @Test
    void checkPassword02() {
        LoginController controller = new LoginController(db);
        assertTrue(controller.checkPassword02("Ying", 123456));
        assertFalse(controller.checkPassword02("Ying", 1234));
    }
}