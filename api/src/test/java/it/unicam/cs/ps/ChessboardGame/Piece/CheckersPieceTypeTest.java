package it.unicam.cs.ps.ChessboardGame.Piece;

import it.unicam.cs.pa.ChessboardGame.Model.Piece.CheckersPieceType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckersPieceTypeTest {
    @Test
    void shouldReturnName() {
        assertEquals("Man", CheckersPieceType.MAN.getName());
        assertEquals("King", CheckersPieceType.KING.getName());
    }

    @Test
    void shouldReturnSymbol() {
        assertEquals("M", CheckersPieceType.MAN.getSymbol());
        assertEquals("K", CheckersPieceType.KING.getSymbol());
    }
}