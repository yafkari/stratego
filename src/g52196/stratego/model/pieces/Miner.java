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

    /**
     * Checks if the current piece is strictly greater than the other one and if
     * it is a bomb
     *
     * @param other the piece to be compared to the current piece
     * @return {@code true} if the current piece is stricly greater than the
     * other one or the other piece is a bomb
     */
    public boolean isStronger(Piece other) {
        return other.getRank() == 11 || super.isStronger(other);
    }
    
    @Override
    public String toString() {
        return "DE";
    }
}
