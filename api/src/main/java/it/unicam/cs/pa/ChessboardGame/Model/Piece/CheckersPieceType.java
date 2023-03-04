package it.unicam.cs.pa.ChessboardGame.Model.Piece;

/**
 * The enum CheckersPieceType, which represent the piece types of the
 * checkers game that is being implemented.
 */
public enum CheckersPieceType implements PieceType {
    /**
     * Man checkers piece type.
     */
    MAN("Man", "M"),
    /**
     * King checkers piece type.
     */
    King("King", "K");

    private final String name;
    private final String symbol;

    CheckersPieceType(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
}
