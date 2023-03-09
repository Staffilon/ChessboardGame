package it.unicam.cs.ps.ChessboardGame.Board;

import it.unicam.cs.pa.ChessboardGame.Model.Board.BoardDimensions;
import it.unicam.cs.pa.ChessboardGame.Model.Board.CheckersBoard;
import it.unicam.cs.pa.ChessboardGame.Model.Board.CheckersPosition;
import it.unicam.cs.pa.ChessboardGame.Model.Board.CheckersSquare;
import it.unicam.cs.pa.ChessboardGame.Model.Color.CheckersColor;
import it.unicam.cs.pa.ChessboardGame.Model.Exceptions.NullPieceException;
import it.unicam.cs.pa.ChessboardGame.Model.Piece.CheckersPiece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CheckersBoardTest {
    private CheckersBoard board;

    @BeforeEach
    void setUp() {
        board = new CheckersBoard();
    }

    @Test
    void shouldCreatePiecesAtStartingPositions() {
        // Check black pieces are in the right position
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < board.getDimensions().columns(); col++) {
                CheckersPosition position = new CheckersPosition(row, col);
                CheckersPiece piece = board.getPieceAt(position);

                if (((position.row() + position.column()) % 2) == 1) {
                    assertNotNull(piece);
                    assertEquals(CheckersColor.BLACK, piece.getColor());
                } else {
                    assertNull(piece);
                }
            }
        }

        // Check white pieces are in the right position
        for (int row = 5; row < board.getDimensions().rows(); row++) {
            for (int col = 0; col < board.getDimensions().columns(); col++) {
                CheckersPosition position = new CheckersPosition(row, col);
                CheckersPiece piece = board.getPieceAt(position);

                if (((position.row() + position.column()) % 2) == 1) {
                    assertNotNull(piece);
                    assertEquals(CheckersColor.WHITE, piece.getColor());
                } else {
                    assertNull(piece);
                }
            }
        }
    }

    @Test
    void shouldReturnNullIfSquareIsEmpty() {
        CheckersPosition emptyPosition = new CheckersPosition(3, 3);
        assertNull(board.getPieceAt(emptyPosition));
    }

    @Test
    void shouldReturnCorrectSquareAndPieceAtPosition() {
        CheckersPosition position = new CheckersPosition(0, 0);
        CheckersSquare square = board.getSquareAt(position);
        CheckersPiece piece = board.getPieceAt(position);

        assertNotNull(square);
        assertFalse(square.isOccupied());
        assertNull(piece);

        board.setPieceAt(new CheckersPiece(CheckersColor.WHITE), position);
        square = board.getSquareAt(position);
        piece = board.getPieceAt(position);

        assertNotNull(square);
        assertTrue(square.isOccupied());
        assertNotNull(piece);
        assertEquals(CheckersColor.WHITE, piece.getColor());
    }

    @Test
    void shouldSetAndRemovePieceAtPosition() {
        CheckersPosition position = new CheckersPosition(1, 1);
        CheckersPiece piece = new CheckersPiece(CheckersColor.BLACK);

        assertFalse(board.getSquareAt(position).isOccupied());
        assertDoesNotThrow(() -> board.setPieceAt(piece, position));
        assertTrue(board.getSquareAt(position).isOccupied());

        assertEquals(piece, board.getPieceAt(position));

        assertDoesNotThrow(() -> board.removePieceAt(position));
        assertFalse(board.getSquareAt(position).isOccupied());
    }

    @Test
    void shouldThrowExceptionWhenSettingNullPiece() {
        CheckersPosition position = new CheckersPosition(0, 0);
        assertThrows(NullPieceException.class, () -> board.setPieceAt(null, position));
    }

    @Test
    void shouldNotRemovePieceFromEmptySquare() {
        CheckersPosition position = new CheckersPosition(1, 1);

        assertFalse(board.getSquareAt(position).isOccupied());
        assertThrows(NullPieceException.class, () -> board.removePieceAt(position));
    }

    @Test
    void shouldThrowExceptionWhenRemovingNullPiece() {
        CheckersPosition position = new CheckersPosition(0, 0);
        assertThrows(NullPieceException.class, () -> board.removePieceAt(position));
    }

    @Test
    void shouldReturnCorrectOccupancy() {
        CheckersPosition occupiedPosition = new CheckersPosition(1, 1);
        CheckersPosition emptyPosition = new CheckersPosition(3, 3);

        board.setPieceAt(new CheckersPiece(CheckersColor.BLACK), occupiedPosition);
        assertTrue(board.isOccupiedAt(occupiedPosition));
        assertFalse(board.isOccupiedAt(emptyPosition));
    }

    @Test
    void shouldReturnCorrectDimensions() {
        BoardDimensions dimensions = board.getDimensions();
        assertEquals(8, dimensions.rows());
        assertEquals(8, dimensions.columns());
    }

    @Test
    void shouldReturnOccupiedSquares() {
        CheckersPosition position = new CheckersPosition(1, 1);
        CheckersPiece piece = new CheckersPiece(CheckersColor.BLACK);

        assertFalse(board.isOccupiedAt(position));
        assertDoesNotThrow(() -> board.setPieceAt(piece, position));
        assertTrue(board.isOccupiedAt(position));
    }

    @Test
    void shouldIterateOverAllPieces() {
        Iterator<CheckersPiece> iterator = board.pieceIterator();
        int count = 0;
        while (iterator.hasNext()) {
            assertNotNull(iterator.next());
            count++;
        }
        assertEquals(24, count);
    }

    @Test
    void shouldReturnListWithThreeAdjacentSquares() {
        CheckersSquare square = board.getSquareAt(new CheckersPosition(0, 0));
        List<CheckersSquare> adjacentSquares = board.getAccessibleSquares(square);
        assertEquals(2, adjacentSquares.size());
    }

    @Test
    void shouldReturnListWithEightAdjacentSquares() {
        CheckersSquare square = board.getSquareAt(new CheckersPosition(3, 3));
        List<CheckersSquare> adjacentSquares = board.getAccessibleSquares(square);
        assertEquals(8, adjacentSquares.size());
    }
}