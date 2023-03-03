package it.unicam.cs.ps.ChessboardGame;

import it.unicam.cs.pa.ChessboardGame.Model.BoardPosition;
import it.unicam.cs.pa.ChessboardGame.Model.CheckersPosition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The CheckersPositionTest class contains the unit tests for the {@link CheckersPosition} class.
 */
public class CheckersPositionTest {
    @Test
    public void shouldHaveCorrectRowAndColumn() {
        BoardPosition position = new CheckersPosition(2, 3);
        assertEquals(2, position.row());
        assertEquals(3, position.column());
    }

    @Test
    public void shouldThrowExceptionWithNegativeValuesConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new CheckersPosition(-1, 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new CheckersPosition(0, -1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new CheckersPosition(-1, -1);
        });
    }

    @Test
    public void shouldReturnTrueIfPositionsAreEqual(){
        BoardPosition position1 = new CheckersPosition(2,3);
        BoardPosition position2 = new CheckersPosition(2,3);
        assertEquals(position1, position2);
    }

    @Test
    public void shouldReturnFalseIfPositionsAreNotEqual(){
        BoardPosition position1 = new CheckersPosition(2,3);
        BoardPosition position2 = new CheckersPosition(3,3);
        assertNotEquals(position1, position2);
    }

    @Test
    public void shouldHaveSameHashCodeIfPositionsAreEqual(){
        BoardPosition position1 = new CheckersPosition(2,3);
        BoardPosition position2 = new CheckersPosition(2,3);
        assertEquals(position1.hashCode(), position2.hashCode());
    }

    @Test
    public void shouldHaveDifferentHashCodeIfPositionsAreNotEqual(){
        BoardPosition position1 = new CheckersPosition(2,3);
        BoardPosition position2 = new CheckersPosition(3,3);
        assertNotEquals(position1.hashCode(), position2.hashCode());
    }
}