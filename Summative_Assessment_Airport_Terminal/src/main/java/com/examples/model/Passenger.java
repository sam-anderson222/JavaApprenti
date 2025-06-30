package com.examples.model;

public record Passenger(String name, String passportNumber) {

    @Override
    public String toString() {
        return String.format("%s, %s", name, passportNumber);
    }
}
