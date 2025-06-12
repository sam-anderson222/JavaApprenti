public class Main {
    public static void main(String[] args) {


        // Main app loop.
        while (true) {
            boolean playRound = true;
            int maxNumber = TerminalUtils.getMaxNumber("Enter max number: ");
            GuessingGameService guessingGame = new GuessingGameService(maxNumber);

            while (playRound) {
                int playerGuess = TerminalUtils.getPlayerGuess(maxNumber);
                GuessResult guessResult = guessingGame.checkGuess(playerGuess);

                switch (guessResult) {
                    case GuessResult.LOWER:
                        TerminalUtils.printMessage("Lower");
                        break;
                    case GuessResult.HIGHER:
                        TerminalUtils.printMessage("Higher");
                        break;
                    case GuessResult.CORRECT:
                        TerminalUtils.printMessage("You got it! Congrats!");
                        playRound = false;
                        break;
                }
            }


            if (TerminalUtils.askIfWantToStopPlaying()) {
                break;
            }
        }

        TerminalUtils.printMessage("(Thanks for playing the number guessing game!)");
    }
}
