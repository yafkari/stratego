package g52196.stratego.model;

/**
 * @author 52196
 *
 * Allows to manage the coordinates of
 * the squares of the game board
 */
public class Position {
    private int row;
    private int column;
    
    /**
     * Constructor
     * 
     * Creates a positon with a row and a column
     * passed in parameter
     * 
     * @param row the position in y
     * @param column the position in x
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * @return the row of the position
     */
    public int getRow() {
        return row;
    }
    
    /**
     * @return the column of the position
     */
    public int getColumn() {
        return column;
    }
    
    
}
