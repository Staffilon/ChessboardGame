package it.unicam.cs.pa.ChessboardGame.Model.Board;

/**
 * The CheckersPosition class represents a position on the checkers board.
 * It implements the {@link BoardPosition} interface, providing methods to access
 * the row and column of the position.
 */
public record CheckersPosition(int row, int column) implements BoardPosition {
    /**
     * Instantiates a new CheckersPosition.
     *
     * @param row    the row
     * @param column the column
     */
    public CheckersPosition {
        if (row < 0 || column < 0) {
            throw new IllegalArgumentException("Row and column must be non-negative");
        }
    }
}