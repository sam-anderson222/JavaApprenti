package com.examples.model;

public class CommercialAircraft extends Aircraft{
    private String airlineName;

    public CommercialAircraft(String model, int passengerCapacity, double fuelCapacity, String airlineName) {
        super(model, passengerCapacity, fuelCapacity);
        this.airlineName = airlineName;
    }

    public String getAirlineName() {
        return airlineName;
    }

    @Override
    public String toString() {
        return String.format("%s, %d, %.1f, %s", model, passengerCapacity, fuelCapacity, airlineName);
    }
}
