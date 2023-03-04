package it.unicam.cs.ps.ChessboardGame.Piece;

import it.unicam.cs.pa.ChessboardGame.Model.Color.CheckersColor;
import it.unicam.cs.pa.ChessboardGame.Model.Exceptions.PieceAlreadyPromotedException;
import it.unicam.cs.pa.ChessboardGame.Model.Piece.CheckersPiece;
import it.unicam.cs.pa.ChessboardGame.Model.Piece.CheckersPieceType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CheckersPieceTest {

    @Test
    void shouldCreateManPiece() {
        CheckersPiece manPiece = new CheckersPiece(CheckersColor.WHITE);
        assertEquals(CheckersPieceType.MAN, manPiece.getPieceType());
        assertFalse(manPiece.hasBeenPromoted());
    }

    @Test
    void shouldPromoteToKing() throws PieceAlreadyPromotedException {
        CheckersPiece manPiece = new CheckersPiece(CheckersColor.WHITE);
        manPiece.promote();
        assertEquals(CheckersPieceType.King, manPiece.getPieceType());
        assertTrue(manPiece.hasBeenPromoted());
    }

    @Test
    void shouldThrowExceptionIfAlreadyPromoted() throws PieceAlreadyPromotedException {
        CheckersPiece kingPiece = new CheckersPiece(CheckersColor.WHITE, CheckersPieceType.King, true);
        PieceAlreadyPromotedException e = assertThrows(PieceAlreadyPromotedException.class, kingPiece::promote);
        assertEquals("checkers piece: " + kingPiece + " is already promoted", e.getMessage());
    }

    @Test
    void shouldThrowExceptionIfPromotingToNullPiece() {
        CheckersPiece manPiece = new CheckersPiece(CheckersColor.WHITE);
        NullPointerException e = assertThrows(NullPointerException.class, () -> {
            manPiece.promote(null);
        });
        assertEquals("The promotion type is null", e.getMessage());
    }

    @Test
    void shouldReturnCorrectColor() {
        CheckersPiece blackPiece = new CheckersPiece(CheckersColor.BLACK);
        assertEquals(CheckersColor.BLACK, blackPiece.getColor());
    }

    @Test
    void shouldSetColor() {
        CheckersPiece whitePiece = new CheckersPiece(CheckersColor.WHITE);
        whitePiece.setColor(CheckersColor.BLACK);
        assertEquals(CheckersColor.BLACK, whitePiece.getColor());
    }
}