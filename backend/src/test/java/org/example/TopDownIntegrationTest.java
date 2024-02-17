package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TopDownIntegrationTest {
    @Nested
    public class ControllerTest {
        Database mockDB;

        @BeforeEach
        public void setUp() {
            mockDB = Mockito.mock(Database.class);
        }

        @Test
        public void TestControllerSuccess() {
            // Test the controller
            Mockito.when(mockDB.getPassword("admin")).thenReturn(123);
            LoginController controller = new LoginController(mockDB);
            User user = new User("admin", 123);
            String result = controller.login(user);
            assertEquals("{\"result\": \"Login successful\"}", result);
        }

        @Test
        public void TestControllerFailure() {
            // Test the controller
            Mockito.when(mockDB.getPassword("admin")).thenReturn(456);
            LoginController controller = new LoginController(mockDB);
            User user = new User("admin", 123);
            String result = controller.login(user);
            assertEquals("{\"result\": \"Invalid username or password\"}", result);
        }
    }

    @Nested
    public class DatabaseTest {
        @Test
        public void TestDataBase() {
            // Test the database
            Database db = new Database();
            assertEquals(db.getPassword("admin"), 123);
            assertNull(db.getPassword("aaaaa"));
        }
    }
}
