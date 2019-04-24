package g52196.stratego.model.pieces;

import g52196.stratego.model.Piece;
import g52196.stratego.model.PlayerColor;

/**
 * @author 52196
 *
 * Represents a type of piece : The Flag
 */
public class Flag extends Piece {

    /**
     * Creates a Flag with a color passed in parameter
     *
     * @param color the color of the flag
     */
    public Flag(PlayerColor color) {
        super(0, color);
    }

    @Override
    public String toString() {
        return "FL";
    }
}
