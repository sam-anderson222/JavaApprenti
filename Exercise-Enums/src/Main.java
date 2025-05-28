public class Main {
    enum CoffeeSize {
        SMALL,
        MEDIUM,
        LARGE
    }

    enum SeatSection {
        GENERAL,
        PREMIUM,
        VIP
    }

    enum TrafficLight {
        RED,
        YELLOW,
        GREEN
    }

    enum Weekday {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    enum AlertLevel {
        LOW,
        MODERATE,
        HIGH,
        SEVERE
    }

    public static void main(String[] args) {
        // Coffee Size
        System.out.println("(Coffee Size)\n");
        CoffeeSize orderSize = CoffeeSize.MEDIUM;
        System.out.println("Selected Coffee Size: "+ orderSize);

        // Seat Reservation
        System.out.println("\n(Seat Reservations)\n");
        System.out.println("GENERAL is assigned value: " + SeatSection.GENERAL.ordinal());
        System.out.println("PREMIUM is assigned value: " + SeatSection.PREMIUM.ordinal());
        System.out.println("VIP is assigned value: " + SeatSection.VIP.ordinal());

        // Traffic Lights
        TrafficLight[] lights = TrafficLight.values();
        TrafficLight currentLightColor = lights[1];
        System.out.println("\n(Traffic Light)\n");
        System.out.println("Traffic light signal: " + currentLightColor);

        // Weekday Schedule
        Weekday currentDay = Weekday.WEDNESDAY;
        boolean isWeekend = (currentDay == Weekday.SATURDAY) || (currentDay == Weekday.SUNDAY);

        System.out.println("\n(Traffic Light)\n");
        System.out.println("Workday selected: " + currentDay);
        System.out.println("Is it a weekend? " + isWeekend);

        // Emergency Alert
        AlertLevel currentAlert = AlertLevel.HIGH;

        System.out.println("\n(Emergency Alert)\n");
        System.out.println("Current alert level: " + currentAlert);

        switch (currentAlert) {
            case LOW:
                System.out.println("No immediate danger.");
                break;
            case MODERATE:
                System.out.println("Stay alert and aware.");
                break;
            case HIGH:
                System.out.println("Take precautions and stay informed.");
                break;
            case SEVERE:
                System.out.println("Immediate action required!");
                break;
        }
    }
}