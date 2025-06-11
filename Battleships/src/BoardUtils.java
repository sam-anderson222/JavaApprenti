public class BoardUtils {


    // Takes a 2D array of tiles and prints the game board state.
    public static void printBoard(Tile[][] bd) {
        // Prints the header (A, B, C, D, ...)
        printHeader(bd.length);

        // Print blips for each tile on the game board.
        for (int i = 0; i < bd.length; i++) {
            System.out.printf("%-2d | ", i+1); // Prints numbers for each row
            for (int j = 0; j < bd.length; j++) {
                printTile(bd[i][j]);
            }
            System.out.println(); // Print newline character
        }
    }

    // Prints the (A, B, C, D, E, ...) header
    private static void printHeader(int numColumns) {
        System.out.print("    ");
        char header = 'A';
        for (int k = 0; k < numColumns; k++) {
            System.out.printf(" %c  ", header);
            header++;
        }
        System.out.println();
    }

    // Prints a different symbol depending on the tile state. Is there a ship? has the tile been guessed? was the guess a hit or miss?
    private static void printTile(Tile currentTile) {
        if (currentTile.getIsShipTile() && currentTile.getHitTile()) { // If a tile with a ship on has been guessed
            System.out.print("H | "); // H for Hit
        } else if (currentTile.getHitTile()) { // If a tile without a shipped has been guessed.
            System.out.print("M | "); // M for Miss
        } else if (currentTile.getIsShipTile()) {
            System.out.print("S | "); // S for Ship (For looking at one's own board)
        } else {
            System.out.print("* | "); // * for an unguessed tile.
        }
    }
}
