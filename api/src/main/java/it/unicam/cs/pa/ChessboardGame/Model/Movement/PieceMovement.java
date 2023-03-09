package it.unicam.cs.pa.ChessboardGame.Model.Movement;

import it.unicam.cs.pa.ChessboardGame.Model.Board.Board;
import it.unicam.cs.pa.ChessboardGame.Model.Board.BoardPosition;
import it.unicam.cs.pa.ChessboardGame.Model.Board.Square;
import it.unicam.cs.pa.ChessboardGame.Model.Piece.Piece;
import it.unicam.cs.pa.ChessboardGame.Model.Piece.PieceType;

import java.util.List;

public interface PieceMovement<B extends BoardPosition, P extends Piece, S extends Square<B, P>,
        T extends Board<B, P, S>> {
    PieceType getPieceType();

    boolean isValidMove(T board, Move<B, P, S> move);

    List<Move<B, P, S>> getValidMoves(T board, S square);

    boolean isCaptureMove(T board, Move<B, P, S> move);

    boolean canCapture(T board, S square);
}