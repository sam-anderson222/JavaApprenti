package com.examples.model;

import java.time.LocalDate;
import java.math.BigDecimal;

public record Flight(String flightNumber, LocalDate departureDate, BigDecimal ticketPrice, Aircraft associatedAircraft) {

    @Override
    public String toString() {
        return String.format("%8s | %10s | $%10s | %14s", flightNumber, departureDate, ticketPrice, associatedAircraft.getModel());
    }
}
