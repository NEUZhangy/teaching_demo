package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {

    @Test
    public void TestDataBase() {
        // Test the database
        Database db = new Database();
        assertEquals(db.getPassword("admin"), 123);
        assertNull(db.getPassword("aaaaa"));
    }
}
