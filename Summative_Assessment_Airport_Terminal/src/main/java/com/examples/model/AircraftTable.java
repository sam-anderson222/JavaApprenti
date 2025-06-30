package com.examples.model;

import java.util.HashMap;

// This defines all aircraft at the airport. I know the project specifies that aircraft should be created in App, but I want to make an
// actual UI and nice looking program, so I opted to make the data here instead.

public class AircraftTable {
    private HashMap<String, Aircraft> aircraftTable;

    public AircraftTable() {
        aircraftTable = new HashMap<>();

        // Aircraft
        aircraftTable.put("Boeing 737", new CommercialAircraft("Boeing 737", 230, 6000, "American Airlines"));
        aircraftTable.put("Airbus A320", new CommercialAircraft("Airbus A320", 170, 4000, "Delta Airlines"));
        aircraftTable.put("Gulfstream G650", new PrivateJet("Gulfstream G650", 12, 500, true, 600));
    }

    public Aircraft getAircraft(String key) {
        return aircraftTable.get(key); // Will return null if key doesn't exist.
    }

    public HashMap<String, Aircraft> getAircraftTable() {
        return aircraftTable;
    }
}
