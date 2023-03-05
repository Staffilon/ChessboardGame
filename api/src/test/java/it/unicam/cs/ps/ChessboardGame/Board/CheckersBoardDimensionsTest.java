package it.unicam.cs.ps.ChessboardGame.Board;

import it.unicam.cs.pa.ChessboardGame.Model.Board.BoardPosition;
import it.unicam.cs.pa.ChessboardGame.Model.Board.CheckersBoardDimensions;
import it.unicam.cs.pa.ChessboardGame.Model.Board.CheckersPosition;
import it.unicam.cs.pa.ChessboardGame.Model.Exceptions.InvalidBoardPositionException;
import it.unicam.cs.pa.ChessboardGame.Model.Exceptions.InvalidPositionNameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The CheckersBoardDimensionsTest class contains the unit tests for the {@link CheckersBoardDimensions} class.
 */
public class CheckersBoardDimensionsTest {
    @Test
    public void shouldHaveCorrectRowAndColumn() {
        BoardPosition position = new CheckersPosition(2, 3, "C3");
        assertEquals(2, position.row());
        assertEquals(3, position.column());
    }

    @Test
    public void shouldThrowExceptionWithNegativeValuesConstructor() {
        assertThrows(InvalidBoardPositionException.class, () -> {
            new CheckersPosition(-1, 0, "A0");
        });
        assertThrows(InvalidBoardPositionException.class, () -> {
            new CheckersPosition(0, -1, "H9");
        });
        assertThrows(InvalidBoardPositionException.class, () -> {
            new CheckersPosition(-1, -1, "D4");
        });
    }

    @Test
    public void shouldThrowExceptionWithInvalidNameConstructor() {
        assertThrows(InvalidPositionNameException.class, () -> {
            new CheckersPosition(2, 3, "AA");
        });
        assertThrows(InvalidPositionNameException.class, () -> {
            new CheckersPosition(2, 3, "1B");
        });
        assertThrows(InvalidPositionNameException.class, () -> {
            new CheckersPosition(2, 3, "I8");
        });
    }

    @Test
    public void shouldReturnTrueIfPositionsAreEqual() {
        BoardPosition position1 = new CheckersPosition(2, 3, "C3");
        BoardPosition position2 = new CheckersPosition(2, 3, "C3");
        assertEquals(position1, position2);
    }

    @Test
    public void shouldReturnFalseIfPositionsAreNotEqual() {
        BoardPosition position1 = new CheckersPosition(2, 3, "C3");
        BoardPosition position2 = new CheckersPosition(3, 3, "C4");
        assertNotEquals(position1, position2);
    }

    @Test
    public void shouldHaveSameHashCodeIfPositionsAreEqual() {
        BoardPosition position1 = new CheckersPosition(2, 3, "C3");
        BoardPosition position2 = new CheckersPosition(2, 3, "C3");
        assertEquals(position1.hashCode(), position2.hashCode());
    }

    @Test
    public void shouldHaveDifferentHashCodeIfPositionsAreNotEqual() {
        BoardPosition position1 = new CheckersPosition(2, 3, "C3");
        BoardPosition position2 = new CheckersPosition(3, 3, "C4");
        assertNotEquals(position1.hashCode(), position2.hashCode());
    }
}