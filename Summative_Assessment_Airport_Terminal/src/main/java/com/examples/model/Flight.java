package com.examples.model;

import java.math.BigDecimal;

public record Flight(String flightNumber, String departureDate, BigDecimal ticketPrice, Aircraft associatedAircraft) {
}
