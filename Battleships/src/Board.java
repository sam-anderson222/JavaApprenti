import java.util.Random;

public class Board {
    private Tile[][] gameBoard;

    // default board size is 10x10
    public Board() {
        Random rng = new Random();
        gameBoard = new Tile[10][10];

        // Give a Tile object to each place on the board.
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                gameBoard[i][j] = new Tile(rng.nextBoolean(), false);
            }
        }
    }

    public Tile getGameTile(String column, int row) {
        try {
            int columnIndex = BoardUtils.mapColumnToIndex(column);
            int rowIndex = row - 1; // Going from 1-based to 0-based

            return gameBoard[columnIndex][rowIndex];
        } catch (Exception ex) {
            return null; // If invalid tile position, then return null meaning tile could not be returned.
        }
    }

    public Tile[][] getGameBoard() {
        return gameBoard;
    }


}
