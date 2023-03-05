package it.unicam.cs.pa.ChessboardGame.Model.Exceptions;

/**
 * The NullPieceException is thrown when a null Piece is given where
 * a not null Piece is expected.
 */
public class NullPieceException extends IllegalArgumentException {
    /**
     * Instantiates a new NullPieceException with a custom message.
     *
     * @param message the message of the exception
     */
    public NullPieceException(String message) {
        super(message);
    }
}