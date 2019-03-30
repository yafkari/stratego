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
    private ArrayList<Piece> pieces;
    
    /**
     * Creates a player with a color
     * passed in parameter and initialize
     * the list of pieces.
     * 
     * @param color
     * @throws NullPointerException if color equals null
     */
    public Player(PlayerColor color) {
        if (color == null) {
            throw new NullPointerException("The color can't be null");
        }
        this.color = color;
        this.pieces = new ArrayList<>();
    }
    
    /**
     * @return the color of the player
     */
    public PlayerColor getColor() {
        return color;
    }
    
    /**
     * @return the list of pieces of the player
     */
    public List<Piece> getPieces() {
        return pieces;
    }
    
    /**
     * Add a piece passed in parameter
     * to the list of pieces of the player
     * 
     * @param piece the piece to be added to the list
     */
    public void addPiece(Piece piece) {
        pieces.add(piece);
    }
    
    /**
     * @return true if the current player has a flag, else false
     */
    public boolean hasFlag() {
        for(Piece piece: pieces) {
            if (piece.hasSameRank(new Flag(PlayerColor.RED))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.color);
        hash = 23 * hash + Objects.hashCode(this.pieces);
        return hash;
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
}
