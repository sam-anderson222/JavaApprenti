public class Board {
    private Tile[][] gameBoard;

    // default board size is 10x10
    public Board() {
        gameBoard = new Tile[10][10];

        // Give a Tile object to each place on the board.
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                gameBoard[i][j] = new Tile(false,false);
            }
        }
    }

    public Tile[][] getGameBoard() {
        return gameBoard;
    }


}
