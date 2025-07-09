package com.examples;

import com.examples.model.AircraftTable;
import com.examples.model.CommercialAircraft;
import com.examples.model.Flight;
import com.examples.model.Passenger;
import com.examples.repository.FlightHardcoded;
import com.examples.repository.ReservationCsv;
import com.examples.service.ReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationCsvTest {
    private ReservationService rs;

    @BeforeEach
    void setUp() {
        File file = new File("data/test/test_data.csv");
        if (file.exists()) {
            file.delete();
        }

        rs = new ReservationService(new ReservationCsv("data/test/test_data.csv", new FlightHardcoded()));
    }


    @Test
    @DisplayName("Can create reservation table.")
    void canCreateReservationTable() {
        assertNotNull(rs.getReservations());
    }

    @Test
    @DisplayName("Can add reservation.")
    void canAddReservation() {
        Passenger p = new Passenger("Joe Smith", "P123");
        rs.addReservation("AA101", p);

        assertEquals(1, rs.getReservations().size());
        assertEquals(p, rs.getReservations().get("AA101").get(0));
    }

    @Test
    @DisplayName("Exception is thrown if null passenger is added to flight.")
    void throwsExceptionWhenNullPassengerAdded() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {rs.addReservation("test", null);});
        assertEquals("Error, passenger is null.", exception.getMessage());
    }

    @Test
    @DisplayName("Exception is thrown when passenger is added to null flight.")
    void throwsExceptionWhenPassengerAddedToInvalidFlight() {
        Passenger p = new Passenger("Test", "Test");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {rs.addReservation("invalid flight number", p);});
        assertEquals("Error, flightNumber is invalid.", exception.getMessage());
    }

    @Test
    @DisplayName("Exception is thrown if passengers list is gotten from invalid flightID.")
    void throwsExceptionWhenInvalidFlightID() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {rs.getPassengersFromFlight("error");});
        assertEquals("Error, flight does not exist.", exception.getMessage());
    }

    @Test
    @DisplayName("Can save and reload reservation.")
    void canSaveReservation() {
        // Adding reservation
        Passenger p = new Passenger("Joe Smith", "P123");
        rs.addReservation("AA101", p); // Flight is saved.

        ReservationService rs2 = new ReservationService(new ReservationCsv("data/test/test_data.csv", new FlightHardcoded()));

        assertEquals(1, rs2.getReservations().size());
    }

    @Test
    @DisplayName("Can get passengers from flight.")
    void canGetPassengersFromFlight() {
        // Adding reservation
        Passenger p = new Passenger("Joe Smith", "P123");
        rs.addReservation("AA101", p); // Flight is saved.

        assertEquals(1, rs.getPassengersFromFlight("AA101").size());
        assertEquals(p, rs.getPassengersFromFlight("AA101").get(0)); // Get the first (and only) person from ArrayList.
    }


}
