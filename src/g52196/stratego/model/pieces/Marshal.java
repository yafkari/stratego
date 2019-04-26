package g52196.stratego.model.pieces;

import g52196.stratego.model.Piece;
import g52196.stratego.model.PlayerColor;

/**
 * Represents a marshal
 * 
 * @author g52196
 */
public class Marshal extends Piece {
    /**
     * Creates a marshal with a color passed in parameter
     *
     * @param color the color of the marshal
     */
    public Marshal(PlayerColor color) {
        super(11, color);
    }

    /**
     * Checks if the other piece is a spy, only if it is true, the marshal wins
     *
     * @param other the piece to be compared to the current piece
     * @return {@code true} if the other piece is a spy
     */
    public boolean isStronger(Piece other) {
        return other.getRank() == 1;
    }
    
    @Override
    public String toString() {
        return "MA";
    }
}
