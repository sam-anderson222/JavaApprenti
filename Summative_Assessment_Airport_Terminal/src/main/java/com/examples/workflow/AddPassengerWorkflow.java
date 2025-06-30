package com.examples.workflow;

import com.examples.model.Passenger;
import com.examples.service.ReservationService;
import com.examples.utils.TerminalUtils;

public class AddPassengerWorkflow {
    public static void execute(ReservationService rs) {

        // Show available flights
        TerminalUtils.printFlights(rs.getFlights());

        // Prompt for user input
        String flightNumber = TerminalUtils.getUserStr("Enter flight number you wish to add passenger to: ");

        // Kick user back if invalid flight number.
        if (!rs.getFlights().containsKey(flightNumber.toUpperCase())) {
            TerminalUtils.printMessage("Error, flight not found. Please try again");
            return;
        }

        String passengerName = TerminalUtils.getUserStr("Enter passenger name: ");
        String passengerPassportNumber = TerminalUtils.getUserStr("Enter passenger passport number: ");

        // Add reservation
        rs.addReservation(flightNumber, new Passenger(passengerName, passengerPassportNumber));

        // Success message
        TerminalUtils.printMessage(String.format("(%s added to flight %s.)", passengerName, flightNumber));

    }
}
