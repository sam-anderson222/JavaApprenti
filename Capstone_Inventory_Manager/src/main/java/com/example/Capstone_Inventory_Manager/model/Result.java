package com.example.Capstone_Inventory_Manager.model;

// Simple result class

public class Result<T> {
    private final boolean success;
    private final String message;
    private final T data;

    public Result(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
