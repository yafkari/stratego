package g52196.stratego.model;

import g52196.stratego.model.pieces.Flag;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author 52196
 *
 * Represents a player
 */
public class Player {

    private PlayerColor color;
    private List<Piece> pieces;

    /**
     * Creates a player of color passed in parameter and not having pieces
     *
     * @param color the color of the player
     * @throws NullPointerException if the color passed in parameter is null
     */
    public Player(PlayerColor color) {
        if (color == null) {
            throw new NullPointerException("The color can't be null");
        }
        this.color = color;
        this.pieces = new ArrayList<>();
    }

    /**
     * Returns the color of the player
     *
     * @return the color of the player
     */
    public PlayerColor getColor() {
        return color;
    }

    /**
     * Returns the list of pieces of the player
     *
     * @return the list of pieces of the player
     */
    public List<Piece> getPieces() {
        return pieces;
    }

    /**
     * Add a piece passed in parameter to the list of pieces of the player
     *
     * @param piece the piece to be added to the list
     */
    public void addPiece(Piece piece) {
        pieces.add(piece);
    }

    /**
     * Checks if the player still has his flag
     *
     * @return {@code true} if the current player has a flag
     */
    public boolean hasFlag() {
        return pieces.contains(new Flag(getColor()));
    }

    /**
     * Removes the piece passed in parameter
     *
     * @param piece the piece to remove
     */
    public void remove(Piece piece) {
        if (pieces.contains(piece)) {
            pieces.remove(piece);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (this.color != other.color) {
            return false;
        }
        if (!Objects.equals(this.pieces, other.pieces)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, pieces);
    }
}
