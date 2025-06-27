package com.examples.repository;

import com.examples.model.Flight;
import com.examples.model.Passenger;
import com.examples.service.ReservationService;

import java.util.ArrayList;
import java.util.HashMap;

public class ReservationCsv implements ReservationRepository {
    HashMap<String, ArrayList<Passenger>> reservations;
    private String filePath;

    public ReservationCsv(String filePath) {
        this.filePath = filePath;
        this.reservations = new HashMap<>();
    }
 
    @Override
    public void load() {

    }

    @Override
    public void save() {

    }

    @Override
    public void addPassenger(Passenger passenger) {

    }

    @Override
    public ArrayList<Passenger> getPassengersFromFlight(Flight flight) {
        return null;
    }

    @Override
    public HashMap<String, ArrayList<Passenger>> getReservations() {
        return null;
    }
}
