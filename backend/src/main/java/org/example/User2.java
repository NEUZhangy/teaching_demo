package org.example;

public class User2 {
    private String username;
    private String password;

    public User2() {
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User2(String userName, String pwd) {
        username = userName;
        password = pwd;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}

