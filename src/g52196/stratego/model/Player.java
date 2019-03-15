package g52196.stratego.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 52196
 *
 * Represents a player
 */
public class Player {
    private PlayerColor color;
    private List<Piece> pieces;
    
    /**
     * Constructor
     * 
     * Creates a player with a color
     * passed in parameter and initialize
     * the list of pieces.
     * 
     * @param color
     */
    public Player(PlayerColor color) {
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
}
