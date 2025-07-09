package com.examples.workflow;

import com.examples.service.ReservationService;
import com.examples.utils.TerminalUtils;

public class GetPassengersFromFlightWorkflow {
    public static void execute(ReservationService rs) {

        // Show available flights
        TerminalUtils.printFlights(rs.getFlights());

        // Prompt for user input
        String flightNumber = TerminalUtils.getUserStr("Enter flight number you wish to reservations for: ");


        // Kick user back if invalid flight number.
        if (!rs.getFlights().containsKey(flightNumber.toUpperCase())) {
            TerminalUtils.printMessage("Error, flight not found. Please try again");
            return;
        }

        // Get ArrayList of passengers from reservation HashMap then print.
        TerminalUtils.printPassengersFromFlight(rs.getPassengersFromFlight(flightNumber));

    }
}
