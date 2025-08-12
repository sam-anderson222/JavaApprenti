package com.example.VoxPopuli.model;

public class User {
    private Integer userId;
    private String username;
    private String userPassword;

    // Default Constructor
    public User() {}

    // Constructor with parameters
    public User(Integer userId, String username, String userPassword) {
        this.userId = userId;
        this.username = username;
        this.userPassword = userPassword;
    }

    // Getters
    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    // Setters

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return String.format("User{userId=%d, username=%s, user_password=%s}", userId, username, userPassword);
    }
}
