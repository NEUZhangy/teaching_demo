package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EndtoEndTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testLoginSuccess() {
        String url = "http://localhost:" + port + "/loginString";
        User2 user = new User2("admin", "123"); // Assuming User is a valid class for the request body
        ResponseEntity<String> response = restTemplate.postForEntity(url, user, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("{\"result\": \"Login successful\"}", response.getBody());
    }

    @Test
    public void testLoginFailure() {
        String url = "http://localhost:" + port + "/loginString";
        User2 user = new User2("user", "456"); // Incorrect credentials
        ResponseEntity<String> response = restTemplate.postForEntity(url, user, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().contains("Invalid username or password"));
    }
}