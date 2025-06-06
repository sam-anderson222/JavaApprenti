public class BoardUtils {


    // Takes a 2D array of tiles and prints the game board state.
    public static void printBoard(Tile[][] bd) {
        for (int i = 0; i < bd.length; i++) {
            for (int j = 0; j < bd.length; j++) {
                Tile currentTile = bd[i][j];
                if (currentTile.getIsShipTile() && currentTile.getHitTile()) { // If a tile with a ship on has been guessed
                    System.out.print("H");
                } else if (currentTile.getHitTile()) { // If a tile without a shipped has been guessed.

                }
            }
            System.out.println();
        }
    }
}
