import java.util.Random;

public class GuessingGameService {
    private int secretNumber; // The number the player is trying to guess.
    private int maxNumber; // (The secret number will be between 1 and the maxNumber)

    public GuessingGameService(int maxNumber) {
        Random rng = new Random();
        this.maxNumber = maxNumber;

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
