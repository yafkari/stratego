package g52196.stratego.model;

/**
 * @author 52196
 * 
 * Represents the possible directions
 */
public enum Direction {
    UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1);
    
    private int row;
    private int column;
    
    private Direction(int row, int column) {
        this.row = row;
        this.column = column;
    }
    
    /**
     * Returns the movement on the y-axis of the direction
     * 
     * @return the movement on the y-axis of the direction
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns the movement on the x-axis of the direction
     * 
     * @return the movement on the x-axis of the direction
     */
    public int getColumn() {
        return column;
    }
}
