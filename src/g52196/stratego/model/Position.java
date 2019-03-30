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
     * Creates a position with a row and a column
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
    
    /**
     * Returns the next position depending 
     * to the direction passed in parameter
     * 
     * @param direction the direction to know the next position
     * @return the next position
     */
    public Position next(Direction direction) {
        return new Position(row + direction.getRow(), 
                column + direction.getColumn());
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
        final Position other = (Position) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.row;
        hash = 61 * hash + this.column;
        return hash;
    }
}
