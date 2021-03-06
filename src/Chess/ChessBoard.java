package Chess;

import GameEntities.GamePiece;

/**
 * The Chessboard class is responsiable for mulipulating the board
 * by moving and removing pieces.
 */
public class ChessBoard {
    private GamePiece[][] board;

    /**
     * Creates the board instance.
     */
    public ChessBoard() {
        board = new GamePiece[8][8];
    }

    /**
     * Checks if piece is at a specificed location.
     * @param row Row of the location.
     * @param col Col of the location.
     * @return Boolean of if theres a piece on location or not.
     */
    public boolean isPieceAt(int row, int col) {
        return board[row][col] != null;
    }

    /**
     * Places piece at location, if piece already exisit there, the old piece will be overwritten.
     * @param piece The piece to move.
     * @param location The location to move to.
     */
    public void placePieceAt(GamePiece piece, ChessLocation location) {
        if (locationInBounds(location) && piece.validMove(location)) {
            if (isPieceAt(location.getRow(), location.getCol())) {
                System.out.println("Piece is here");
                removePieceAt(location);
            }
            removePieceAt(piece.getChessLocation());
            board[location.getRow()][location.getCol()] = piece;
            piece.moveTo(location);
        } else {
            System.out.println("Not a valid move, try again.");
        }
    }

    /**
     * Removes piece at location.
     * @param location The location to remove at.
     */
    private void removePieceAt(ChessLocation location) {
        board[location.getRow()][location.getCol()] = null;
    }

    /**
     * Setup piece which bypasses valid move check from piece.
     * Used for initalizing piece on board.
     * @param piece The piece to set up.
     * @param location The location to set up at.
     */
    public void setupPieceAt(GamePiece piece, ChessLocation location) {
        board[location.getRow()][location.getCol()] = piece;
        piece.moveTo(location);
    }

    /**
     * Checks if the location is within the board.
     * @param location The location to check.
     * @return Boolean of if the location is in bounds or not.
     */
    private boolean locationInBounds(ChessLocation location) {
        return location.getRow() >= 0 && location.getRow() < 8 && location.getRow() >= 0 && location.getCol() < 8;
    }

    /**
     * Displays board with P being Piece.
     */
    public void displayBoard() {
        System.out.println("  0 1 2 3 4 5 6 7");
        for (int row = 0; row < 8; row++) {
            System.out.print(row);
            for (int col = 0; col < 8; col++) {
                if (board[row][col] != null) {
                    System.out.print(" P");
                } else {
                    System.out.print(" -");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
