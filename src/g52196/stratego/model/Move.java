package g52196.stratego.model;

import java.util.Objects;

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
     * Creates a move that have a piece, a start and a end position received in
     * parameter
     *
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
     * Returns the piece to move
     *
     * @return the piece to move
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Returns the starting position
     *
     * @return the starting position
     */
    public Position getStart() {
        return start;
    }

    /**
     * Returns the position of arrival
     *
     * @return the position of arrival
     */
    public Position getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Move other = (Move) obj;
        if (!Objects.equals(this.piece, other.piece)) {
            return false;
        }
        if (!Objects.equals(this.start, other.start)) {
            return false;
        }
        if (!Objects.equals(this.end, other.end)) {
            return false;
        }
        return true;
    }
}
