package com.examples;

import com.examples.model.Passenger;
import com.examples.repository.ReservationCsv;
import com.examples.service.ReservationService;
import com.examples.utils.TerminalUtils;
import com.examples.workflow.AddPassengerWorkflow;
import com.examples.workflow.GetPassengersFromFlightWorkflow;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ReservationService rs = new ReservationService(new ReservationCsv("data/main/reservation.csv"));
        boolean runProgram = true;

        while (runProgram) {
            TerminalUtils.printMenu();
            String userInput = TerminalUtils.getUserStr("Enter an option: ");
            switch (userInput) {
                case "1":
                    AddPassengerWorkflow.execute(rs);
                    break;
                case "2":
                    GetPassengersFromFlightWorkflow.execute(rs);
                    break;
                case "3":
                    runProgram = false;
                    break;
                default:
                    TerminalUtils.printMessage("Error, unknown input received. Please try again.");
                    break;
            }
        }

        // Thank you mesage
        TerminalUtils.printMessage("\n(Thank you for using the airport terminal program)");
    }
}
