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
    public Square() {
        piece = null;
    }
    
    /**
     * Returns the piece in the square
     * 
     * @return the piece in the square
     */
    public Piece getPiece() {
        return piece;
    }
    
    /**
     * Checks if the piece is empty
     * 
     * @return if the piece is empty
     */
    public boolean isFree() {
        return piece == null;
    }
    
    /**
     * Add a piece to the square if
     * the piece is not null
     * and the square is free
     * 
     * @param piece the piece to be added
     * @throws NullPointerException if the piece passed in parameter is null
     * @throws IllegalStateException if the square is not empty
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
    
    /**
     * Checks if the current piece has 
     * the same color than the player
     * 
     * @param color the color of the current piece
     * @return true if the piece has the same color than the player otherwise false
     */
    public boolean isMyOwn(PlayerColor color) {
        if (!isFree()) {
            return getPiece().getColor() == color;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(piece);
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

        return Objects.equals(this.piece, other.piece);
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
