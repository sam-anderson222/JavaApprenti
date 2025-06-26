package com.examples.repository;

import com.examples.model.*;
import java.util.ArrayList;
import java.util.HashMap;


public interface ReservationRepository {
    void load();
    void save();
    void addPassenger(Passenger passenger);
    ArrayList<Passenger> getPassengersFromFlight(Flight flight);
    HashMap<String, ArrayList<Passenger>> getReservations();
}
