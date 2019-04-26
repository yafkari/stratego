package g52196.stratego.model.pieces;

import g52196.stratego.model.Piece;
import g52196.stratego.model.PlayerColor;

/**
 * Represents a pathfinder
 *
 * @author g52196
 */
public class Pathfinder extends Piece {

    /**
     * Creates a pathfinder with a color passed in parameter
     *
     * @param color the color of the pathfinder
     */
    public Pathfinder(PlayerColor color) {
        super(2, color, 2);
    }

    @Override
    public String toString() {
        return "PA";
    }
}
