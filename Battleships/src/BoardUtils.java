// Holds a collection of important board utilities used for printing / guessing tiles on the board.

public class BoardUtils {


    // Takes a 2D array of tiles and prints the game board state.
    public static void printBoard(Tile[][] bd) {
        // Prints the header (A, B, C, D, ...)
        IO.printBoardHeader(bd.length);

        // Print blips for each tile on the game board.
        for (int i = 0; i < bd.length; i++) {
            System.out.printf("%-2d |", i+1); // Prints numbers for each row
            for (int j = 0; j < bd.length; j++) {
                System.out.printf(" %s |", getTileIcon(bd[i][j]));
            }
            System.out.println(); // Print newline character
        }
    }

    // Returns a different symbol depending on the tile state. Is there a ship? has the tile been guessed? was the guess a hit or miss?
    private static String getTileIcon(Tile currentTile) {
        if (currentTile.getShipTile() && currentTile.getHitTile()) { // If a tile with a ship on has been guessed
            return "H"; // H for Hit
        } else if (currentTile.getHitTile()) { // If a tile without a shipped has been guessed.
            return "-"; // - for Miss
        } else if (currentTile.getShipTile()) {
            return "*"; // ^ for Ship (For looking at one's own board)
        } else {
            return "*"; // * for an unguessed tile.
        }
    }

    // Maps a column character to an index (ex: A -> 0, B -> 1, and so on)
    public static int mapColumnToIndex(String column) throws IllegalStateException {
        return switch (column) {
            case "A" -> 0;
            case "B" -> 1;
            case "C" -> 2;
            case "D" -> 3;
            case "E" -> 4;
            case "F" -> 5;
            case "G" -> 6;
            case "H" -> 7;
            case "I" -> 8;
            case "J" -> 9;
            default -> throw new IllegalStateException("Unexpected value: " + column); // Throw error if column character is not valid.
        } ;
    }
}
