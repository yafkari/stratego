package g52196.stratego.model.pieces;

import g52196.stratego.model.Piece;
import g52196.stratego.model.PlayerColor;

/**
 * @author 52196
 *
 * Represents a type of piece : The General
 */
public class General extends Piece {

    /**
     * Creates a General with a color passed in parameter
     *
     * @param color the color of the general
     */
    public General(PlayerColor color) {
        super(9, color);
    }

    @Override
    public String toString() {
        return "GE";
    }
}
