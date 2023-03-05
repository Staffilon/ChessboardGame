package it.unicam.cs.ps.ChessboardGame.Board;

import it.unicam.cs.pa.ChessboardGame.Model.Board.BoardPosition;
import it.unicam.cs.pa.ChessboardGame.Model.Board.CheckersPosition;
import it.unicam.cs.pa.ChessboardGame.Model.Exceptions.InvalidBoardPositionException;
import it.unicam.cs.pa.ChessboardGame.Model.Exceptions.InvalidPositionNameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The CheckersPositionTest class contains the unit tests for the {@link CheckersPosition} class.
 */
public class CheckersPositionTest {
    @Test
    public void shouldHaveCorrectRowAndColumnAndName() {
        BoardPosition position = new CheckersPosition(2, 3, "C2");
        assertEquals(2, position.row());
        assertEquals(3, position.column());
        assertEquals("C2", position.name());
    }

    @Test
    public void shouldThrowExceptionWithOutOfBoundsConstructor() {
        assertThrows(InvalidBoardPositionException.class, () -> {
            new CheckersPosition(-1, 0, "A1");
        });
        assertThrows(InvalidBoardPositionException.class, () -> {
            new CheckersPosition(0, -1, "A1");
        });
        assertThrows(InvalidBoardPositionException.class, () -> {
            new CheckersPosition(-1, -1, "A1");
        });

        assertThrows(InvalidBoardPositionException.class, () -> {
            new CheckersPosition(8, 0, "A1");
        });
        assertThrows(InvalidBoardPositionException.class, () -> {
            new CheckersPosition(0, 8, "A1");
        });
        assertThrows(InvalidBoardPositionException.class, () -> {
            new CheckersPosition(8, 8, "A1");
        });
    }

    @Test
    public void shouldThrowExceptionWithInvalidPositionNameConstructor() {
        assertThrows(InvalidPositionNameException.class, () -> {
            new CheckersPosition(0, 0, "A0");
        });
        assertThrows(InvalidPositionNameException.class, () -> {
            new CheckersPosition(0, 0, "I1");
        });
        assertThrows(InvalidPositionNameException.class, () -> {
            new CheckersPosition(0, 0, "A9");
        });
        assertThrows(InvalidPositionNameException.class, () -> {
            new CheckersPosition(0, 0, "i9");
        });
        assertThrows(InvalidPositionNameException.class, () -> {
            new CheckersPosition(0, 0, "B");
        });
    }

    @Test
    public void shouldReturnTrueIfPositionsAreEqual() {
        BoardPosition position1 = new CheckersPosition(2, 3, "C2");
        BoardPosition position2 = new CheckersPosition(2, 3, "C2");
        assertEquals(position1, position2);
    }

    @Test
    public void shouldReturnFalseIfPositionsAreNotEqual() {
        BoardPosition position1 = new CheckersPosition(2, 3, "C2");
        BoardPosition position2 = new CheckersPosition(3, 3, "C3");
        assertNotEquals(position1, position2);
    }

    @Test
    public void shouldHaveSameHashCodeIfPositionsAreEqual() {
        BoardPosition position1 = new CheckersPosition(2, 3, "C2");
        BoardPosition position2 = new CheckersPosition(2, 3, "C2");
        assertEquals(position1.hashCode(), position2.hashCode());
    }

    @Test
    public void shouldHaveDifferentHashCodeIfPositionsAreNotEqual() {
        BoardPosition position1 = new CheckersPosition(2, 3, "C2");
        BoardPosition position2 = new CheckersPosition(3, 3, "C3");
        assertNotEquals(position1.hashCode(), position2.hashCode());
    }
}