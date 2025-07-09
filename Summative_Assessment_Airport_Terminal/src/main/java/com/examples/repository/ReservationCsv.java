package com.examples.repository;

import com.examples.model.*;
import com.examples.service.ReservationService;
import com.examples.utils.TerminalUtils;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class ReservationCsv implements ReservationRepository {
    private final FlightRepository flightRepository; // Holds the flights
    private final HashMap<String, ArrayList<Passenger>> reservations;
    private final AircraftTable aircraftTable;
    private final String filePath;

    public ReservationCsv(String filePath, FlightRepository flightRepository) {
        this.filePath = filePath;
        this.flightRepository = flightRepository;
        this.reservations = new HashMap<>();
        aircraftTable = new AircraftTable();

        // Load data from file.
        load();
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

                    if (dataFields.length == 7) { // Only parse data if there is enough fields.
                        Passenger passenger = new Passenger(dataFields[3], dataFields[4]);

                        // If flight isn't already added.
                        if (!reservations.containsKey(dataFields[0])) {
                            flightRepository.addFlight(dataFields[0], new Flight(dataFields[0], LocalDate.parse(dataFields[1]), new BigDecimal(dataFields[2]), aircraftTable.getAircraft(dataFields[5])));
                            reservations.put(dataFields[0], new ArrayList<>());
                        }

                        reservations.get(dataFields[0]).add(passenger);  // Add passenger to ArrayList.
                    }
                }
            } catch (Exception ex) {
                TerminalUtils.printMessage("Error. Could not open and load from file.");
            }
        }

    }

    @Override
    public void save() {
        File file = new File(filePath);

        // I know it says to append to the file, but that won't work, so I'm doing it.
        try (PrintWriter writer = new PrintWriter(file)) { // Creates file if there is none.
            for (String flightNumber: reservations.keySet()) {
                for (Passenger passenger: reservations.get(flightNumber)) {
                    Flight flight = flightRepository.getFlight(flightNumber);
                    String aircraftType;

                    if (flight == null) { // If there is no flight (commonly in test cases) don't save this to file.
                        continue;
                    }


                    if (flight.associatedAircraft() instanceof CommercialAircraft) {
                        aircraftType = "Commercial";
                    } else {
                        aircraftType = "PrivateJet";
                    }

                    String entry = String.format("%s,%s,%s,%s,%s,%s,%s",
                            flightNumber,
                            flight.departureDate(),
                            flight.ticketPrice(),
                            passenger.name(),
                            passenger.passportNumber(),
                            flight.associatedAircraft().getModel(),
                            aircraftType);

                    writer.println(entry);
                }
            }
        } catch (Exception ex) {
            System.out.println("Error with saving file");
        }

    }

    @Override
    public void addReservation(String flightNumber, Passenger passenger) {
        if (passenger == null) {
            throw new IllegalArgumentException("Error, passenger is null.");
        }

        if (!reservations.containsKey(flightNumber)) {
            reservations.put(flightNumber, new ArrayList<>());
        }

        reservations.get(flightNumber).add(passenger);
        save();
    }


    @Override
    public ArrayList<Passenger> getPassengersFromFlight(String flightNumber) {
        return reservations.get(flightNumber);
    }

    @Override
    public HashMap<String, ArrayList<Passenger>> getReservations() {
        return reservations;
    }

    @Override
    public HashMap<String, Flight> getFlights() {
        return flightRepository.getFlights();
    }
}
