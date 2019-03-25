package g52196.stratego.model;

/**
 * @author 52196
 *
 * Represents the game board
 */
public class Board {
    private Square[][] squares = new Square[5][4];
    
    /**
     * Creates empty squares on a board with
     * 5 rows and 4 columns
     * 
     */
    Board() {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                squares[i][j] = new Square();
            }
        }
    }
    
    /**
     * @return the board
     */
    Square[][] getSquares() {
        return squares;
    }

    /**
     * Checks the board contains the
     * position passed in parameter
     * 
     * @param position the position to check
     * @return true if the board contains the position
     */
    boolean isInside(Position position) {
        
        if (position.getRow() < 0 || position.getRow() > squares.length-1) {
            return false;
        }
        
        if (position.getColumn() < 0 || position.getColumn() > squares[position.getRow()].length-1) {
            return false;
        }

        return true;
    }
    
    /**
     * Get the square at the position
     * passed in parameter
     * 
     * @param position the position of the square to get
     * @return the square at the position passed in paramter
     * @throws IllegalArgumentException if the position is not on the board
     */
    Square getSquare(Position position) {
        if (!isInside(position)) {
             throw new IllegalArgumentException("The position is not on the board");
        } else {
            return squares[position.getRow()][position.getColumn()];
        }
    }
    
    /**
     * Put a piece on the board in the position 
     * passed in paramater
     * 
     * @param piece the piece to be added to the board
     * @param position the position where the piece have to be added
     * @throws IllegalArgumentException if the position is not on the board
     */
    void put(Piece piece, Position position) {
        if (!isInside(position)) {
             throw new IllegalArgumentException("The position is not on the board");
        } else {
            squares[position.getRow()][position.getColumn()].put(piece);
        }
    }
}
