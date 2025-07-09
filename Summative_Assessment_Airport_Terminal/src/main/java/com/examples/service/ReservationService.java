package com.examples.service;

import com.examples.model.Flight;
import com.examples.model.Passenger;
import com.examples.repository.ReservationRepository;

import java.util.ArrayList;
import java.util.HashMap;

public class ReservationService {
    ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    public void addReservation(String flightNumber, Passenger passenger) {
        repository.addReservation(flightNumber, passenger);
    }

    public ArrayList<Passenger> getPassengersFromFlight(String flightNumber) {
        return repository.getPassengersFromFlight(flightNumber);
    }

    public HashMap<String, ArrayList<Passenger>> getReservations() {
        return repository.getReservations();
    }

    public HashMap<String, Flight> getFlights() {
        return repository.getFlights();
    }
}
