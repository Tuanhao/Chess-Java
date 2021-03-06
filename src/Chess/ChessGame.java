package Chess;

import GameEntities.*;

/**
 * The ChessGame class is used for holding chess objects
 * which contains the board, pieces and handles alternating turns.
 */
public class ChessGame {

    private ChessBoard chessBoard;
    //TEMP FOR ASSINGMENT ONE
    private GamePiece firstPiece;

    /**
     * Create new instances of nessary properties.
     */
    public ChessGame() {
        chessBoard = new ChessBoard();
        firstPiece = new Knight("white", new ChessLocation(0,0), this);
    }

    /**
     * Returns the ChessBoard.
     * @return The board object of the chess game.
     */
    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    /**
     * TEMP FOR ASSINGMENT ONE
     * Returns the piece to move.
     * @return The only piece on the board to move.
     */
    public GamePiece getPiece() {
        return firstPiece;
    }
}