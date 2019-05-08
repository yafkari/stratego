package g52196.stratego.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 52196
 *
 * Represents the board of the game The board has 6 rows and 5 columns
 */
public class Board {

    private Square[][] squares = new Square[6][5];

    /**
     * Creates empty squares on the board with 6 rows and 5 columns with 3
     * squares that are of type water, others are of type land
     */
    public Board() {
        for (int row = 0; row < squares.length; row++) {
            for (int column = 0; column < squares[row].length; column++) {
                if (row == 2 && column == 1 || row == 2 && column == 2
                        || row == 2 && column == 3) {
                    squares[row][column] = new Square(SquareType.WATER);
                } else {
                    squares[row][column] = new Square(SquareType.LAND);
                }
            }
        }
    }

    /**
     * Returns the board
     *
     * @return the board
     */
    Square[][] getSquares() {
        return squares;
    }

    /**
     * Checks if the board contains the position passed in parameter
     *
     * @param position the position to check
     * @return {@code true} if the board contains the position
     */
    boolean isInside(Position position) {

        if (position.getRow() < 0 || position.getRow() > squares.length - 1
                || position.getColumn() < 0
                || position.getColumn() > squares[position.getRow()].length - 1) {
            return false;
        }

        return true;
    }

    /**
     * Get the square at the position passed in parameter
     *
     * @param position the position of the square to get
     * @return the square at the position passed in parameter
     * @throws IllegalArgumentException if the position is not on the board
     */
    Square getSquare(Position position) {
        if (!isInside(position)) {
            throw new IllegalArgumentException(
                    "The position is not on the board");
        }
        return squares[position.getRow()][position.getColumn()];
    }

    /**
     * Put a piece on the board in the position passed in parameter
     *
     * @param piece the piece to be added to the board
     * @param position the position where the piece have to be added
     * @throws IllegalArgumentException if the position is not on the board
     */
    void put(Piece piece, Position position) {
        if (!isInside(position)) {
            throw new IllegalArgumentException(
                    "The position is not on the board");
        }
        getSquare(position).put(piece);
    }

    /**
     * Checks if the square at the position passed in parameter is empty
     *
     * @param position the position to be checked
     * @return {@code true} if the square at the position in parameter is null
     * @throws IllegalArgumentException if the given position is not on the
     * board
     */
    public boolean isFree(Position position) {
        if (!isInside(position)) {
            throw new IllegalArgumentException(
                    "The position is not on the board");
        }
        return getSquare(position).isFree();
    }

    /**
     * Checks if the square at the position passed in parameter is owned by the
     * player with the given color
     *
     * @param position the position of the square
     * @param color the color of the player
     * @return {@code true} if the square is owned by the given color
     */
    public boolean isMyOwn(Position position, PlayerColor color) {

        return getSquare(position).isMyOwn(color);
    }

    /**
     * Returns the piece at the position passed in parameter
     * 
     * @param position the position of the piece
     * @return the piece at the position passed in parameter
     * @throws IllegalArgumentException if the position is not in the board
     */
    public Piece getPiece(Position position) {
        if (!isInside(position)) {
            throw new IllegalArgumentException("The position is not in the board");
        }
        return getSquare(position).getPiece();
    }
    
    /**
     * Removes a piece from the board
     *
     * @param position the position of the piece to remove
     * @throws IllegalArgumentException if the given position is not on the
     * board
     */
    public void remove(Position position) {
        if (!isInside(position)) {
            throw new IllegalArgumentException(
                    "The position is not on the board");
        }

        if (!getSquare(position).isFree()) {
            this.getSquares()[position.getRow()][position.getColumn()]
                    = this.getSquares()[position.getRow()][position.getColumn()]
                            .isLand()
                            ? new Square(SquareType.LAND)
                            : new Square(SquareType.WATER);
        }
    }

    /**
     * Returns the list of squares owned by the player passed in parameter
     *
     * @param player the player for who we look for the taken squares
     * @return the list of squares owned by the player passed in parameter
     */
    public List<Position> getTakenSquare(Player player) {
        List<Position> takenSquares = new ArrayList<>();

        for (int i = 0; i < getSquares().length; i++) {
            for (int j = 0; j < getSquares()[i].length; j++) {
                if (getSquares()[i][j].isMyOwn(player.getColor())) {
                    takenSquares.add(new Position(i, j));
                }
            }
        }

        return takenSquares;
    }
}
