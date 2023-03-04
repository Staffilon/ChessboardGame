package it.unicam.cs.pa.ChessboardGame.Model.Board;

import it.unicam.cs.pa.ChessboardGame.Model.Piece.CheckersPiece;

import java.util.Iterator;

public class CheckersBoard implements Board<CheckersPosition, CheckersPiece, CheckersSquare> {
    @Override
    public CheckersSquare getSquareAt(CheckersPosition position) throws IllegalArgumentException {
        return null;
    }

    @Override
    public CheckersPiece getPieceAt(CheckersPosition position) throws IllegalArgumentException {
        return null;
    }

    @Override
    public void setPieceAt(CheckersPiece piece, CheckersPosition position) throws IllegalArgumentException {

    }

    @Override
    public CheckersPiece removePieceAt(CheckersPosition position) throws IllegalArgumentException {
        return null;
    }

    @Override
    public boolean isOccupiedAt(CheckersPosition position) throws IllegalArgumentException {
        return false;
    }

    @Override
    public BoardDimensions getDimensions() {
        return null;
    }

    @Override
    public Iterator<CheckersSquare> iterator() {
        return null;
    }

    @Override
    public Iterator<CheckersPiece> pieceIterator() {
        return null;
    }
}