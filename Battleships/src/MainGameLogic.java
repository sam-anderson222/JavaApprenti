public class MainGameLogic {

    /*
    Battleships
    Board (Made up of 5 ships of differing sizes on 10x10 board)
    BoardUtils handles board functions.
    Tiles (Makes up the board, can have a ship or be hit.)
    Ships (A ship with a length, position, and rotation on the board. One of 5 types)
    Players (Each player has their own board with their own orientation of their ships)
    Game logic (Each player takes turns guessing where the other player ships are)

     */
    public static void main(String[] args) {
        Board p1Board = new Board();
        Board p2Board = new Board();

        IO.printMessage("Your Board: ");
        BoardUtils.printBoard(p1Board.getGameBoard());

        IO.printMessage("Opponent's Board: ");
        BoardUtils.printBoard(p2Board.getGameBoard());


    }
}
