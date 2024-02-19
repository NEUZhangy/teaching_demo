package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BottomUpIntegrationTest {
    Database db = new Database();

    @Test
    public void TestDataBase() {
        // Test the database
        assertEquals(db.getPassword("admin"), 123);
        assertNull(db.getPassword("aaaaa"));
    }

    @Test
    public void TestController() {
        // Test the controller
        LoginController2 controller = new LoginController2(db);
        User2 user = new User2("admin", "123");
        String result = controller.login(user);
        assertEquals("{\"result\": \"Login successful\"}", result);
    }
}
