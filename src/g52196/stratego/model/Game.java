package g52196.stratego.model;

/**
 * @author 52196
 *
 * Represents the current game
 */
public class Game implements Model {
    private Board board;
    private Player current;
    private Player opponent;
    
    /**
     * Constructor
     * 
     * Creates a game with a player and an opponent
     * 
     * The player is red
     * Te opponent is blue
     */
    public Game() {
        current = new Player(PlayerColor.RED);
        opponent = new Player(PlayerColor.BLUE);
    }
    
    /**
     * Initialize the game board with
     * one flag and a general for each player
     */
    @Override
    public void initialize() {
        board = new Board();
        
        Piece redFlag = new Piece(0, current.getColor());
        Piece blueFlag = new Piece(0, opponent.getColor());
        Piece redGeneral = new Piece(9, current.getColor());
        Piece blueGeneral = new Piece(9, opponent.getColor());
        
        board.put(redFlag, new Position(0,1));
        board.put(blueFlag, new Position(4,2));
        board.put(redGeneral, new Position(3,2));
        board.put(blueGeneral, new Position(4,1));
        
        current.addPiece(redFlag);
        current.addPiece(redGeneral);
        opponent.addPiece(blueFlag);
        opponent.addPiece(blueGeneral); 
    }
    
    /**
     * Checks if a match can start.
     */
    @Override
    public void start() {
        if (board == null) {
            throw new IllegalStateException("The board is not set");
        }
    }
    
    /**
     * Declares if it's the end of the game.
     *
     * @return true if it's the end of the game.
     */
    @Override
    public boolean isOver() {
        return false;
    }
    
    /**
     * Returns the board.
     *
     * @return the board.
     */
    @Override
    public Square[][] getBoard() {
        return board.getSquares();
    }
    
    
}
