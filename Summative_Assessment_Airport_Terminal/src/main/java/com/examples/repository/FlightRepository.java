package com.examples.repository;

import com.examples.model.Flight;

import java.util.HashMap;

public interface FlightRepository {
    Flight getFlight(String flightNumber);
    void addFlight(String flightNumber, Flight flight); // Used when you want to get flight data from file or user input.
    HashMap<String, Flight> getFlights();

}
