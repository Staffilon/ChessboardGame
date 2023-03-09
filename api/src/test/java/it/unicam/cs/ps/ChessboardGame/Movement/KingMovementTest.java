package it.unicam.cs.ps.ChessboardGame.Movement;

import it.unicam.cs.pa.ChessboardGame.Model.Board.CheckersBoard;
import it.unicam.cs.pa.ChessboardGame.Model.Board.CheckersPosition;
import it.unicam.cs.pa.ChessboardGame.Model.Board.CheckersSquare;
import it.unicam.cs.pa.ChessboardGame.Model.Color.CheckersColor;
import it.unicam.cs.pa.ChessboardGame.Model.Movement.CheckersMove;
import it.unicam.cs.pa.ChessboardGame.Model.Movement.KingMovement;
import it.unicam.cs.pa.ChessboardGame.Model.Movement.Move;
import it.unicam.cs.pa.ChessboardGame.Model.Piece.CheckersPiece;
import it.unicam.cs.pa.ChessboardGame.Model.Piece.CheckersPieceType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KingMovementTest {
    private final KingMovement kingMovement = new KingMovement();
    CheckersBoard board;

    @BeforeEach
    void setup() {
        board = new CheckersBoard();
    }

    @Test
    public void shouldReturnValidPieceType() {
        assertEquals(CheckersPieceType.KING, kingMovement.getPieceType());
    }

    @Test
    public void shouldReturnTrueWhenMoveIsValid() {
        CheckersPosition fromPosition = new CheckersPosition(4, 1);
        CheckersPosition toPosition = new CheckersPosition(3, 2);

        CheckersPiece piece = new CheckersPiece(CheckersColor.BLACK, CheckersPieceType.KING, true);

        board.setPieceAt(piece, fromPosition);
        CheckersSquare square = board.getSquareAt(fromPosition);
        CheckersSquare adjacentSquare = board.getSquareAt(toPosition);
        Move<CheckersPosition, CheckersPiece, CheckersSquare> move = new CheckersMove(square, adjacentSquare);

        assertTrue(kingMovement.isValidMove(board, move));
    }

    @Test
    public void shouldReturnTrueWhenIsCaptureMove() {
        CheckersPosition fromPosition = new CheckersPosition(4, 1);
        CheckersPosition toPosition = new CheckersPosition(2, 3);
        CheckersPosition inBetweenPosition = new CheckersPosition(3, 2);

        CheckersPiece piece = new CheckersPiece(CheckersColor.BLACK, CheckersPieceType.KING, true);
        CheckersPiece capturedPiece = new CheckersPiece(CheckersColor.WHITE, CheckersPieceType.KING, true);

        board.setPieceAt(piece, fromPosition);
        board.setPieceAt(capturedPiece, inBetweenPosition);
        board.removePieceAt(toPosition);
        CheckersSquare square = board.getSquareAt(fromPosition);
        CheckersSquare adjacentSquare = board.getSquareAt(toPosition);
        Move<CheckersPosition, CheckersPiece, CheckersSquare> move = new CheckersMove(square, adjacentSquare);

        assertTrue(kingMovement.isCaptureMove(board, move));
    }

    @Test
    public void shouldReturnFalseWhenIsNotCaptureMove() {
        CheckersPosition fromPosition = new CheckersPosition(4, 1);
        CheckersPosition toPosition = new CheckersPosition(3, 2);

        CheckersPiece piece = new CheckersPiece(CheckersColor.BLACK, CheckersPieceType.KING, true);

        board.setPieceAt(piece, fromPosition);
        CheckersSquare square = board.getSquareAt(fromPosition);
        CheckersSquare adjacentSquare = board.getSquareAt(toPosition);
        Move<CheckersPosition, CheckersPiece, CheckersSquare> move = new CheckersMove(square, adjacentSquare);

        assertFalse(kingMovement.isCaptureMove(board, move));
    }

    @Test
    public void shouldReturnFalseWhenPiecesOnSquaresAreInvalid() {
        CheckersSquare square = board.getSquareAt(new CheckersPosition(3, 2));
        CheckersSquare adjacentSquare = board.getSquareAt(new CheckersPosition(2, 3));

        Move<CheckersPosition, CheckersPiece, CheckersSquare> move = new CheckersMove(square, adjacentSquare);
        assertFalse(kingMovement.isValidMove(board, move));
    }

    @Test
    public void shouldReturnFalseWhenMoveLengthIsInvalid() {
        CheckersSquare square = board.getSquareAt(new CheckersPosition(3, 2));
        CheckersSquare adjacentSquare = board.getSquareAt(new CheckersPosition(5, 4));
        CheckersPiece piece = new CheckersPiece(CheckersColor.BLACK, CheckersPieceType.KING, true);
        board.setPieceAt(piece, new CheckersPosition(3, 2));

        Move<CheckersPosition, CheckersPiece, CheckersSquare> move = new CheckersMove(square, adjacentSquare);
        assertFalse(kingMovement.isValidMove(board, move));
    }

    @Test
    public void shouldReturnFalseWhenCaptureIsInvalid() {
        CheckersPosition fromPosition = new CheckersPosition(4, 1);
        CheckersPosition toPosition = new CheckersPosition(2, 3);
        CheckersPosition inBetweenPosition = new CheckersPosition(3, 2);

        CheckersPiece piece = new CheckersPiece(CheckersColor.BLACK, CheckersPieceType.KING, true);
        CheckersPiece capturedPiece = new CheckersPiece(CheckersColor.WHITE, CheckersPieceType.KING, true);

        board.setPieceAt(piece, fromPosition);
        board.setPieceAt(capturedPiece, inBetweenPosition);

        CheckersSquare fromSquare = board.getSquareAt(fromPosition);
        CheckersSquare toSquare = board.getSquareAt(toPosition);
        Move<CheckersPosition, CheckersPiece, CheckersSquare> move = new CheckersMove(fromSquare, toSquare);
        assertFalse(kingMovement.isValidMove(board, move));
    }

    @Test
    public void shouldReturnTrueWhenCaptureIsValid() {
        CheckersPosition fromPosition = new CheckersPosition(4, 1);
        CheckersPosition toPosition = new CheckersPosition(2, 3);
        CheckersPosition inBetweenPosition = new CheckersPosition(3, 2);

        CheckersPiece piece = new CheckersPiece(CheckersColor.BLACK, CheckersPieceType.KING, true);
        CheckersPiece capturedPiece = new CheckersPiece(CheckersColor.WHITE, CheckersPieceType.KING, true);

        board.setPieceAt(piece, fromPosition);
        board.setPieceAt(capturedPiece, inBetweenPosition);
        board.removePieceAt(toPosition);

        CheckersSquare fromSquare = board.getSquareAt(fromPosition);
        CheckersSquare toSquare = board.getSquareAt(toPosition);
        Move<CheckersPosition, CheckersPiece, CheckersSquare> move = new CheckersMove(fromSquare, toSquare);
        assertTrue(kingMovement.isValidMove(board, move));
    }

    @Test
    public void shouldReturnFalseWhenCapturedPieceIsInvalid() {
        CheckersPosition fromPosition = new CheckersPosition(4, 1);
        CheckersPosition toPosition = new CheckersPosition(2, 3);
        CheckersPosition inBetweenPosition = new CheckersPosition(3, 2);

        CheckersPiece piece = new CheckersPiece(CheckersColor.BLACK, CheckersPieceType.KING, true);
        CheckersPiece capturedPiece = new CheckersPiece(CheckersColor.BLACK, CheckersPieceType.KING, true);

        board.setPieceAt(piece, fromPosition);
        board.setPieceAt(capturedPiece, inBetweenPosition);
        board.removePieceAt(toPosition);

        CheckersSquare fromSquare = board.getSquareAt(fromPosition);
        CheckersSquare toSquare = board.getSquareAt(toPosition);
        Move<CheckersPosition, CheckersPiece, CheckersSquare> move = new CheckersMove(fromSquare, toSquare);
        assertFalse(kingMovement.isValidMove(board, move));
    }

    @Test
    public void shouldReturnAllValidMoves() {
        CheckersPosition fromPosition1 = new CheckersPosition(5, 0);
        CheckersPosition fromPosition2 = new CheckersPosition(5, 2);
        CheckersPosition fromPosition3 = new CheckersPosition(7, 0);

        CheckersPiece piece = new CheckersPiece(CheckersColor.BLACK, CheckersPieceType.KING, true);

        board.setPieceAt(piece, fromPosition1);
        board.setPieceAt(piece, fromPosition2);
        board.setPieceAt(piece, fromPosition3);

        assertEquals(1, kingMovement.getValidMoves(board, board.getSquareAt(fromPosition1)).size());
        assertEquals(2, kingMovement.getValidMoves(board, board.getSquareAt(fromPosition2)).size());
        assertEquals(0, kingMovement.getValidMoves(board, board.getSquareAt(fromPosition3)).size());
    }

    @Test
    public void shouldBeAbleToCapture() {
        CheckersPosition fromPosition = new CheckersPosition(5, 2);
        CheckersPosition inBetweenPosition = new CheckersPosition(4, 3);

        CheckersPiece piece = new CheckersPiece(CheckersColor.BLACK, CheckersPieceType.KING, true);
        CheckersPiece capturedPiece = new CheckersPiece(CheckersColor.WHITE, CheckersPieceType.KING, true);

        board.setPieceAt(piece, fromPosition);
        board.setPieceAt(capturedPiece, inBetweenPosition);
        assertTrue(kingMovement.canCapture(board, board.getSquareAt(fromPosition)));
    }

    @Test
    public void shouldNotBeAbleToCapture() {
        CheckersPosition fromPosition = new CheckersPosition(5, 2);
        CheckersPosition inBetweenPosition = new CheckersPosition(4, 3);

        CheckersPiece piece = new CheckersPiece(CheckersColor.BLACK, CheckersPieceType.KING, true);
        CheckersPiece capturedPiece = new CheckersPiece(CheckersColor.BLACK, CheckersPieceType.KING, true);

        board.setPieceAt(piece, fromPosition);
        board.setPieceAt(capturedPiece, inBetweenPosition);
        assertFalse(kingMovement.canCapture(board, board.getSquareAt(fromPosition)));
    }
}