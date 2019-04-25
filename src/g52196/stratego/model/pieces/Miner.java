package g52196.stratego.model.pieces;

import g52196.stratego.model.Piece;
import g52196.stratego.model.PlayerColor;

/**
 * @author 52196
 *
 * Represents a miner
 */
public class Miner extends Piece {

    /**
     * Creates a miner with a color passed in parameter
     *
     * @param color the color of the bomb
     */
    public Miner(PlayerColor color) {
        super(3, color);
    }
}
