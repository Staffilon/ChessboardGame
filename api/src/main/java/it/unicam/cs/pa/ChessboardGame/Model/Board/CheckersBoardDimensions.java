package it.unicam.cs.pa.ChessboardGame.Model.Board;

import it.unicam.cs.pa.ChessboardGame.Model.Exceptions.InvalidBoardDimensionsException;

public record CheckersBoardDimensions(int columns, int rows) implements BoardDimensions {
    public CheckersBoardDimensions {
        validateDimensions(columns, rows);
    }

    private void validateDimensions(int columns, int rows) {
        if (columns <= 0 || rows <= 0) {
            throw new InvalidBoardDimensionsException("Board dimensions must be positive!");
        }
    }
}