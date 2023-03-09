package it.unicam.cs.ps.ChessboardGame.Board;

import it.unicam.cs.pa.ChessboardGame.Model.Board.BoardPosition;
import it.unicam.cs.pa.ChessboardGame.Model.Board.CheckersBoardDimensions;
import it.unicam.cs.pa.ChessboardGame.Model.Board.CheckersPosition;
import it.unicam.cs.pa.ChessboardGame.Model.Exceptions.InvalidBoardPositionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The CheckersBoardDimensionsTest class contains the unit tests for the {@link CheckersBoardDimensions} class.
 */
public class CheckersBoardDimensionsTest {
    @Test
    public void shouldHaveCorrectRowAndColumn() {
        BoardPosition position = new CheckersPosition(2, 3);
        assertEquals(2, position.row());
        assertEquals(3, position.column());
    }

    @Test
    public void shouldThrowExceptionWithInvalidValuesConstructor() {
        assertThrows(InvalidBoardPositionException.class, () -> {
            new CheckersPosition(-1, 0);
        });
        assertThrows(InvalidBoardPositionException.class, () -> {
            new CheckersPosition(0, -1);
        });
        assertThrows(InvalidBoardPositionException.class, () -> {
            new CheckersPosition(-1, -1);
        });

        assertThrows(InvalidBoardPositionException.class, () -> {
            new CheckersPosition(9, 8);
        });
        assertThrows(InvalidBoardPositionException.class, () -> {
            new CheckersPosition(8, 9);
        });
        assertThrows(InvalidBoardPositionException.class, () -> {
            new CheckersPosition(9, 9);
        });
    }

    @Test
    public void shouldReturnTrueIfPositionsAreEqual() {
        BoardPosition position1 = new CheckersPosition(2, 3);
        BoardPosition position2 = new CheckersPosition(2, 3);
        assertEquals(position1, position2);
    }

    @Test
    public void shouldReturnFalseIfPositionsAreNotEqual() {
        BoardPosition position1 = new CheckersPosition(2, 3);
        BoardPosition position2 = new CheckersPosition(3, 3);
        assertNotEquals(position1, position2);
    }

    @Test
    public void shouldHaveSameHashCodeIfPositionsAreEqual() {
        BoardPosition position1 = new CheckersPosition(2, 3);
        BoardPosition position2 = new CheckersPosition(2, 3);
        assertEquals(position1.hashCode(), position2.hashCode());
    }

    @Test
    public void shouldHaveDifferentHashCodeIfPositionsAreNotEqual() {
        BoardPosition position1 = new CheckersPosition(2, 3);
        BoardPosition position2 = new CheckersPosition(3, 3);
        assertNotEquals(position1.hashCode(), position2.hashCode());
    }
}