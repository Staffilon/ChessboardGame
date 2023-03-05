package it.unicam.cs.pa.ChessboardGame.Model.Board;

import it.unicam.cs.pa.ChessboardGame.Model.Piece.Piece;

import java.util.Iterator;

/**
 * @param <B>
 * @param <P>
 * @param <T>
 */

public interface Board<B extends BoardPosition, P extends Piece, T extends Square<B, P>> {
    /**
     * Returns the square at the specified position on the board.
     *
     * @param position the position of the square to retrieve
     * @return the square at the specified position
     * @throws IllegalArgumentException if the position is invalid for this board
     */
    T getSquareAt(B position) throws IllegalArgumentException;

    /**
     * Returns the piece at the specified position on the board.
     *
     * @param position the position of the piece to retrieve
     * @return the piece at the specified position, or null if no piece is present
     * @throws IllegalArgumentException if the position is invalid for this board
     */
    P getPieceAt(B position) throws IllegalArgumentException;

    /**
     * Sets the specified piece at the specified position on the board.
     *
     * @param piece    the piece to be placed on the board
     * @param position the position where the piece will be placed
     * @throws IllegalArgumentException if the position is invalid for this board
     */
    void setPieceAt(P piece, B position) throws IllegalArgumentException;

    /**
     * Removes the piece at the specified position on the board.
     *
     * @param position the position of the piece to be removed
     * @return the removed piece, or null if no piece was present
     * @throws IllegalArgumentException if the position is invalid for this board
     */
    P removePieceAt(B position) throws IllegalArgumentException;

    /**
     * Returns whether the specified position on the board is occupied by a piece.
     *
     * @param position the position to check for occupation
     * @return true if the position is occupied by a piece, false otherwise
     * @throws IllegalArgumentException if the position is invalid for this board
     */
    boolean isOccupiedAt(B position) throws IllegalArgumentException;

    /**
     * Returns the dimensions of the board.
     *
     * @return the dimensions of the board
     */
    BoardDimensions getDimensions();

    /**
     * Returns an iterator over the squares on the board.
     *
     * @return an iterator over the squares on the board
     */
    Iterator<T> iterator();

    /**
     * Returns an iterator over the pieces on the board.
     *
     * @return an iterator over the pieces on the board
     */
    Iterator<P> pieceIterator();
}