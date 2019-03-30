package g52196.stratego.model;

/**
 * @author 52196
 *
 * Represents a possible movement of a piece
 */
public class Move {
    private Piece piece;
    private Position start;
    private Position end;

    /**
     * @param piece the piece to move
     * @param start the starting position
     * @param end the position of arrival 
     * @throws NullPointerException if a parameter is null
     */
    public Move(Piece piece, Position start, Position end) {
        if (piece == null || start == null || end == null) {
            throw new NullPointerException("The parameters can't be null");
        }
        
        this.piece = piece;
        this.start = start;
        this.end = end;
    }

    /**
     * @return the piece to move
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * @return the starting position
     */
    public Position getStart() {
        return start;
    }

    /**
     * @return the position of arrival
     */
    public Position getEnd() {
        return end;
    }
}
