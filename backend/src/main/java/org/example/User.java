package org.example;

public class User {
    private String username;
    private int password;

    public User() {
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public User(String userName, int pwd) {
        username = userName;
        password = pwd;
    }

    public String getUsername() {
        return username;
    }

    public int getPassword() {
        return password;
    }

}

