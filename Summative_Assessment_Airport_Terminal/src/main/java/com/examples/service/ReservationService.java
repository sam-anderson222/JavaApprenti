package com.examples.service;

import com.examples.model.Passenger;
import com.examples.repository.ReservationRepository;

import java.util.ArrayList;
import java.util.HashMap;

public class ReservationService {
    ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    public void addPassenger(String flightNumber, Passenger passenger) {
        repository.addPassenger(flightNumber, passenger);
    }

    public HashMap<String, ArrayList<Passenger>> getReservations() {
        return repository.getReservations();
    }
}
