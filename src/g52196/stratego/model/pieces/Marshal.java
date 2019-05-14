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
        super(10, color);
    }

    @Override
    public String toString() {
        return "MA";
    }
}
