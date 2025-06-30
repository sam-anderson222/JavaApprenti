package com.examples.model;

import java.time.LocalDate;
import java.math.BigDecimal;

public record Flight(String flightNumber, LocalDate departureDate, BigDecimal ticketPrice, Aircraft associatedAircraft) {
}
