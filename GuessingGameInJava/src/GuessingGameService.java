import java.util.Random;

public class GuessingGameService {
    private final int secretNumber; // The number the player is trying to guess.

    public GuessingGameService(int maxNumber) {
        Random rng = new Random();

        secretNumber = rng.nextInt(1, maxNumber + 1); // Plus one as is exclusive.
    }

    public GuessResult checkGuess(int playerGuess) {
        if (playerGuess < secretNumber) {
            return GuessResult.HIGHER;
        } else if (playerGuess > secretNumber) {
            return GuessResult.LOWER;
        } else {
            return GuessResult.CORRECT;
        }
    }
}
