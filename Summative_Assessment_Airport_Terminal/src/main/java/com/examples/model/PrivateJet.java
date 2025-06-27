package com.examples.model;

public class PrivateJet extends Aircraft{
    private boolean hasLuxuryService;
    private int maxSpeed;

    public PrivateJet(String model, int passengerCapacity, double fuelCapacity, boolean hasLuxuryService, int maxSpeed) {
        super(model, passengerCapacity, fuelCapacity);
        this.hasLuxuryService = hasLuxuryService;
        this.maxSpeed = maxSpeed;
    }

    public boolean isHasLuxuryService() {
        return hasLuxuryService;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
