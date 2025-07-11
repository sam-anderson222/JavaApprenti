package com.example.Capstone_Inventory_Manager.model;

// Simple result class

public record Result<T> (boolean isSuccess, String message, T data) {}
