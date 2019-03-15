package g52196.stratego.model;

/**
 * @author 52196
 * 
 * Represents military units.
 */
public class Piece {
    private int rank;
    private PlayerColor color;
    
    /**
     * Constructor
     * 
     * Creates a Piece with a rank and a color that
     * have been passed in parameter.
     * 
     * @param rank the rank of the piece
     * @param color the color of the piece
     */
    public Piece(int rank, PlayerColor color) {
        if (rank < 0) {
            throw new IllegalArgumentException("The rank must be strictly positive");
        }
        this.rank = rank;
        this.color = color;
    }
    
    /**
     * @return the rank of the piece
     */
    public int getRank() {
        return rank;
    }
    
    /**     * 
     * @return the color of the piece
     */
    public PlayerColor getColor() {
        return color;
    }
    
    
    
}
