package it.unicam.cs.pa.ChessboardGame.Model.Board;

import it.unicam.cs.pa.ChessboardGame.Model.Exceptions.InvalidBoardPositionException;
import it.unicam.cs.pa.ChessboardGame.Model.Exceptions.InvalidPositionNameException;

/**
 * The CheckersPosition class represents a position on the checkers board.
 * It implements the {@link BoardPosition} interface, providing methods to access
 * the row and column of the position.
 */
public record CheckersPosition(int row, int column, String name) implements BoardPosition {
    /**
     * Instantiates a new CheckersPosition.
     *
     * @param row    the row
     * @param column the column
     */
    public CheckersPosition {
        if (row < 0 || column < 0 || row > 7 || column > 7) {
            throw new InvalidBoardPositionException("Row and column must be with bounds");
        }
        if (!name.matches("^[A-H][1-8]$")) {
            throw new InvalidPositionNameException("Invalid position name: " + name);
        }
    }
}