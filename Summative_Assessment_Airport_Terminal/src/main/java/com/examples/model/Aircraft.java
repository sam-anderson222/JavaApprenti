package com.examples.model;

public class Aircraft {
    protected String model;
    protected int passengerCapacity;
    protected double fuelCapacity;

    public Aircraft(String model, int passengerCapacity, double fuelCapacity) {
        this.model = model;
        this.passengerCapacity = passengerCapacity;
        this.fuelCapacity = fuelCapacity;
    }

    public String getModel() {
        return model;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    @Override
    public String toString() {
        return String.format("%s, %d, %.1f", model, passengerCapacity, fuelCapacity);
    }
}
