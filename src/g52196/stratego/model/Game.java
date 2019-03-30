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
    private Position selected;
    
    /**
     * Creates a game with a player and an opponent
     * 
     * The player is red
     * The opponent is blue
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
     * 
     * @throws IllegalStateException if the board is not set yet
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
     * @return true if it is the end of the game.
     */
    @Override
    public boolean isOver() {
        return false;
    }
    
    /**
     * @return the squares of the board
     */
    @Override
    public Square[][] getBoard() {
        return board.getSquares();
    }
    
    /**
     * Select a piece on the current board
     * 
     * @param row the row of the desired piece
     * @param column the column of the desired piece
     * @throws IllegalArgumentException if the position is not on the board
     * @throws IllegalArgumentException if the square at the position is empty
     * @throws IllegalArgumentException if the square is not owned by the player
     */
    @Override
    public void select(int row, int column) {
        if (!board.isInside(new Position(row, column))) {
            throw new IllegalArgumentException(
                    "The position is not on the board");
        }
        if (board.getSquare(new Position(row, column)).isFree()) {
            throw new IllegalArgumentException(
                    "You are trying to select an empty square");
        }
        if (!board.isMyOwn(new Position(row, column), current.getColor())) {
            throw new IllegalArgumentException(
                    "You are trying to select an opponent piece");
        }
        
        selected = new Position(row, column);
    }
    
    /**
     * @return the selected piece
     * @throws NullPointerException if the selected piece is empty
     */
    @Override
    public Piece getSelected() {
        if (selected == null) {
            throw new NullPointerException("The selected piece is empty");
        }
        return board.getSquare(selected).getPiece();
    };
}
