package g52196.stratego.model;

import java.util.Objects;

/**
 * @author 52196
 *
 * Represents a cell on the game board
 */
public class Square {
    private Piece piece;
    
    /**
     * Creates an empty square
     */
    Square() {
        piece = null;
    }
    
    /**
     * @return the piece in the square
     */
    public Piece getPiece() {
        return piece;
    }
    
    /**
     * @return if the piece is empty
     */
    public Boolean isFree() {
        return piece == null;
    }
    
    /**
     * Add a piece to the square if
     * - the piece is not null
     * - the square is free
     * 
     * @param piece the piece to be added
     */
    public void put(Piece piece) {
        if (piece == null) {
            throw new NullPointerException("The piece can't be null");
        } else if (!isFree()) {
            throw new IllegalStateException("The square is not free");
        } else {
            this.piece = piece;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.piece);
        return hash;
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
        final Square other = (Square) obj;
        if (!Objects.equals(this.piece, other.piece)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (piece == null) {
            return " ";
        } else {
            return piece.toString();

        }
    }
}
