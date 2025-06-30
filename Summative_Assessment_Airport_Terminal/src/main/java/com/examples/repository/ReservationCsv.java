package com.examples.repository;

import com.examples.model.AircraftTable;
import com.examples.model.Flight;
import com.examples.model.Passenger;
import com.examples.service.ReservationService;
import com.examples.utils.TerminalUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class ReservationCsv implements ReservationRepository {
    private final HashMap<String, ArrayList<Passenger>> reservations;
    private final ArrayList<Flight> flights; // stores all flights.
    private final AircraftTable aircraftTable;
    private String filePath;

    public ReservationCsv(String filePath) {
        this.filePath = filePath;
        this.reservations = new HashMap<>();
        this.flights = new ArrayList<>();
        aircraftTable = new AircraftTable();
    }

    @Override
    public void load() {
        File file = new File(filePath);

        if (file.exists()) { // Try to read from file if it exists.
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String dataEntry;

                while((dataEntry = reader.readLine()) != null) {
                    // [0] - flightNumber, [1] - departureDate, [2] - ticketPrice, [3] - passengerName, [4] - passportNumber, [5] - aircraftModel, [6] - aircraftType
                    String[] dataFields = dataEntry.split(","); // Split on comma as we are using CSV.

                    Passenger passenger = new Passenger(dataFields[3], dataFields[4]);

                    // If flight is already added
                    if (reservations.containsKey(dataFields[0])) {
                        reservations.get(dataFields[1]).add(passenger);  // Add passenger to ArrayList.
                    } else { // If flight number not in reservation, then create a new flight object and passengers ArrayList
                        flights.add(new Flight(dataFields[0], LocalDate.parse(dataFields[1]), new BigDecimal(dataFields[2]), aircraftTable.getAircraft(dataFields[5])));
                        reservations.get(dataFields[0]).add(passenger);
                    }
                }
            } catch (Exception ex) {
                TerminalUtils.printMessage("Error. Could not open and load from file.");
            }
        }

    }

    @Override
    public void save() {

    }

    @Override
    public void addPassenger(String flightNumber, Passenger passenger) {

    }

    @Override
    public ArrayList<Passenger> getPassengersFromFlight(String flightNumber) {
        return null;
    }

    @Override
    public HashMap<String, ArrayList<Passenger>> getReservations() {
        return reservations;
    }

    @Override
    public ArrayList<Flight> getFlights() {
        return flights;
    }
}
