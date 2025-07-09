package com.examples.repository;

import com.examples.model.*;
import java.util.ArrayList;
import java.util.HashMap;


public interface ReservationRepository {
    void load();
    void save();
    void addReservation(String flightNumber, Passenger passenger);
    ArrayList<Passenger> getPassengersFromFlight(String flightNumber);
    HashMap<String, ArrayList<Passenger>> getReservations();
    HashMap<String, Flight> getFlights();
}
