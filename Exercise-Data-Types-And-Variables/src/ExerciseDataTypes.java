public class ExerciseDataTypes {
    public static void main(String[] args) {
        // 1 Sport Stats Variables
        String playerName = "Ronaldo";
        String teamName = "Portugal National";
        String position = "Forward";
        int jerseyNumber = 7;
        boolean isStarter = true;

        // 2 Movie Stat Variables
        String movieTitle = "Raiders of the Lost Ark";
        String rating = "PG";
        String leadActor = "Harrison Ford";
        int releaseYear = 1981;
        boolean isSequel = false;

        // 3 Weather Report
        String cityName = "Austin";
        String weatherCondition = "Cloudy";
        float temperature = 80f;
        float humidity = 90f;
        boolean isRaining = false;

        // 4 Flight Information
        String flightNumber = "AA554";
        String departureCity = "New York City";
        String arrivalCity = "Houston";
        int gateNumber = 54;
        int terminal = 6;
        boolean isDelayed = true;

        // Printing
        System.out.println("\n(Printing the variables)\n");

        System.out.println(playerName + " plays for " + teamName + " in the " + position +
                " position." + " He wears jersey number " + jerseyNumber + " and it is " + isStarter + " that he is a starter.");

        System.out.println(movieTitle + " is a " + rating + " rated movie released in " + releaseYear +
                ". It stars " + leadActor + " as the actor. It is " + isSequel + " that the movie is a sequel to another movies.");

        System.out.println("In " + cityName + " it is currently " + temperature + "F and " + weatherCondition +
                ". The current humidity is " + humidity + "% and it is " + isRaining + " that is raining.");

        System.out.println("flightNumber " + flightNumber + " departs from " + departureCity + " and arrives in " +
                arrivalCity + ". Boarding is located at " + gateNumber + " in terminal " + terminal + ". It is " + isDelayed + " that the flight is delayed.");

        // Updating / reprinting variables
        jerseyNumber = 4;
        isStarter = false;

        rating = "PG-13";
        isSequel = true;

        temperature = 95f;
        weatherCondition = "Sunny";

        gateNumber = 46;
        isDelayed = false;

        System.out.println("\n(After changing the variables)\n");

        System.out.println(playerName + " plays for " + teamName + " in the " + position +
                " position." + " He wears jersey number " + jerseyNumber + " and it is " + isStarter + " that he is a starter.");

        System.out.println(movieTitle + " is a " + rating + " rated movie released in " + releaseYear +
                ". It stars " + leadActor + " as the actor. It is " + isSequel + " that the movie is a sequel to another movies.");

        System.out.println("In " + cityName + " it is currently " + temperature + "F and " + weatherCondition +
                ". The current humidity is " + humidity + "% and it is " + isRaining + " that is raining.");

        System.out.println("flightNumber " + flightNumber + " departs from " + departureCity + " and arrives in " +
                arrivalCity + ". Boarding is located at " + gateNumber + " in terminal " + terminal + ". It is " + isDelayed + " that the flight is delayed.");

        // 4 Working with booleans
        boolean hasHomework = true;
        boolean isWeekend = false;
        boolean attendedClass = true;

        System.out.println("\n(Working with booleans)\n");

        System.out.println("Do I have homework? " + hasHomework);
        System.out.println("Is it the weekend? " + isWeekend);
        System.out.println("Did I attend class today? " + attendedClass);

        // 5 Working with chars
        System.out.println("\n(Working with chars)\n");
        char firstInitial = 'S';
        char lastInitial = 'A';
        char favoriteGrade = 'A';

        System.out.println("My first and last initials are: " + firstInitial + ". " +
                lastInitial + ". and my favorite letter grade is " + favoriteGrade + ".");





    }
}