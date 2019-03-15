package g52196.stratego.model;

/**
 * @author 52196
 *
 * Represents a cell on the game board
 */
public class Square {
    private Piece piece;
    
    Square() {
        piece = null;
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
            throw new IllegalArgumentException("The piece can't be null");
        } else if (!isFree()) {
            throw new IllegalArgumentException("The square is not free");
        } else {
            this.piece = piece;
        }
    }
}
