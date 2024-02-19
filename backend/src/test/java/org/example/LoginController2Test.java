package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginController2Test {
    Database db = new Database();
    @Test
    void login() {
        LoginController2 controller = new LoginController2(db);
        User2 user = new User2("admin", "123");
        String result = controller.login(user);
        assertEquals("{\"result\": \"Login successful\"}", result);
    }

    @Test
    void checkUser01() {
        LoginController2 controller = new LoginController2(db);
        User2 user = new User2("admin", "123");
        assertTrue(controller.checkUser01(user));
    }

    @Test
    void checkPassword02() {
        LoginController2 controller = new LoginController2(db);
        assertTrue(controller.checkPassword02("Ying", "123456"));
        assertFalse(controller.checkPassword02("Ying", "1234678"));
    }

    @Test
    void isValidPwd() {
        assertFalse(LoginController2.isValidPwd("123"));
        assertTrue(LoginController2.isValidPwd("123456"));
        assertFalse(LoginController2.isValidPwd("11111111"));
    }
}