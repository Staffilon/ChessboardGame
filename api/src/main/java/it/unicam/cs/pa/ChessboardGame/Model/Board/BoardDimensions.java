package it.unicam.cs.pa.ChessboardGame.Model.Board;

/**
 * The BoardDimensions interface creates an abstraction for the representation the dimensions of a board.
 * It provides methods to get the number of rows and columns in the board.
 */
public interface BoardDimensions {
    /**
     * Returns the number of rows in the board.
     *
     * @return the number of rows in the board
     */
    int getRows();

    /**
     * Returns the number of columns in the board.
     *
     * @return the number of columns in the board
     */
    int getColumns();
}