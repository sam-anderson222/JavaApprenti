package com.examples.repository;

import com.examples.model.AircraftTable;
import com.examples.model.Flight;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;

public class FlightHardcoded implements FlightRepository {
    private final HashMap<String, Flight> flights; // stores all flights.
    private final AircraftTable aircraftTable;

    public FlightHardcoded() {
        flights = new HashMap<>();
        aircraftTable = new AircraftTable();

        // Adding hard-coded flight data
        flights.put("AA101", new Flight("AA101", LocalDate.parse("2024-10-10"), new BigDecimal("299.99"), aircraftTable.getAircraft("Boeing 737")));
        flights.put("SWA11", new Flight("SWA11", LocalDate.parse("2024-10-06"), new BigDecimal("199.99"), aircraftTable.getAircraft("Airbus A320")));
        flights.put("P001", new Flight("P001", LocalDate.parse("2024-09-25"), new BigDecimal("499.99"), aircraftTable.getAircraft("Gulfstream G650")));
    }

    @Override
    public Flight getFlight(String flightNumber) {
        return flights.get(flightNumber);
    }

    @Override
    public void addFlight(String flightNumber, Flight flight) {
        return;
    }

    @Override
    public HashMap<String, Flight> getFlights() {
        return flights;
    }
}
