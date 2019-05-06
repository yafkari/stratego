package g52196.stratego.model.pieces;

import g52196.stratego.model.Piece;
import g52196.stratego.model.PlayerColor;

/**
 * Represents a spy
 *
 * @author g52196
 */
public class Spy extends Piece {

    /**
     * Creates a spy with a color passed in parameter
     *
     * @param color the color of the marshal
     */
    public Spy(PlayerColor color) {
        super(1, color);
    }

    /**
     * Checks if the other piece is a marshal, only if it is true, the spy wins
     *
     * @param other the piece to be compared to the current piece
     * @return {@code true} if the other piece is a marshal
     */
    public boolean isStronger(Piece other) {
        return other.getRank() == 10 || super.isStronger(other);
    }

    @Override
    public String toString() {
        return "SP";
    }
}
