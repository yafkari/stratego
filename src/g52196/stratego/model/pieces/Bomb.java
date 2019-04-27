package g52196.stratego.model.pieces;

import g52196.stratego.model.Piece;
import g52196.stratego.model.PlayerColor;

/**
 * @author 52196
 *
 * Represents a bomb
 */
public class Bomb extends Piece {

    /**
     * Creates a bomb with a color passed in parameter
     *
     * @param color the color of the bomb
     */
    public Bomb(PlayerColor color) {
        super(11, 0, color);
    }

    @Override
    public String toString() {
        return "BO";
    }
}
