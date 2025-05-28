public class Main {
    public static void main(String[] args) {
        // Finance
        System.out.println("\n(Finance)\n");
        double loanAmount = 25000.00; // in dollars
        double annualInterestRate = 5.5; // as a percentage
        int loanTermYears = 5;
        double monthlyPayment;

        // 1
        loanAmount += 5000;
        annualInterestRate -= 1;
        loanTermYears++;

        monthlyPayment = (loanAmount * (annualInterestRate/100)/12);

        // 2
        System.out.println("loanAmount exceeds $30,000: " + (loanAmount > 30000));
        System.out.println("monthlyPayment exceeds $500: " + (monthlyPayment > 500));

        // 3
        System.out.println("Loan is affordable: " + (monthlyPayment < 500 && loanTermYears > 3));
        System.out.println("Loan is expensive: " + (monthlyPayment > 700 || annualInterestRate > 6));


        // Weather
        System.out.println("\n(Weather)\n");
        double temperatureCelsius = 25.0; // Current temperature in Celsius
        boolean isRaining = false; // Indicates if it's raining
        int windSpeedKmh = 10; // Wind speed in km/h

        // 1
        double temperatureFahrenheit = ((temperatureCelsius * 9) / 5) + 32;

        // 2
        temperatureFahrenheit += 5;
        windSpeedKmh += 5;

        // 3
        System.out.println("Temperature Fahrenheit exceeds 85F: " + (temperatureFahrenheit > 85.0));
        System.out.println("Wind Speeds exceeds 20 km/h: " + (windSpeedKmh > 20));

        // 4
        System.out.println("Is it a good day to go outside: " + (!isRaining && (temperatureFahrenheit > 60 && temperatureFahrenheit < 85)));
        System.out.println("Is there a weather warning: " + (windSpeedKmh > 30 || temperatureFahrenheit < 32)); // 32F == 0C



        // Gaming
        System.out.println("\n(Gaming)\n");
        int currentXP = 1200; // experience points
        int level = 5;
        int xpToNextLevel = 1500;
        boolean levelUp;

        // 1
        currentXP += 300;
        xpToNextLevel -= 300;
        currentXP *= 2; // Since xp increased by 1,500, xpToNextLevel must decrease by 1,500
        xpToNextLevel -= 1500;

        // 2
        System.out.println("currentXP exceeds xpToNextLevel: " + (currentXP >= xpToNextLevel));
        System.out.println("Player has reached level 10: " + (level >= 10));

        // 3
        levelUp = (currentXP >= xpToNextLevel) && (level < 10);
        System.out.println("Will player level up: " + (levelUp));
        System.out.println("Is player a pro: " + ((level > 7) && (currentXP > 5000)));

        // 4
        System.out.println("Player Stats: ");
        System.out.println("Xp: " + currentXP);
        System.out.println("Xp to next level: " + xpToNextLevel);
        System.out.println("Level: " + level);
        System.out.println("Level-up status: " + levelUp);


    }
}
