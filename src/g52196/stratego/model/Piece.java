package g52196.stratego.model;

import java.util.Objects;

/**
 * @author 52196
 *
 * Represents military units.
 */
public class Piece {

    private int rank;
    private PlayerColor color;
    private int nbSteps;

    /**
     * Creates a Piece with a number of steps of one and with a rank and a color
     * that have been passed in parameter.
     *
     * @param rank the rank of the piece
     * @param color the color of the piece
     * @throws IllegalArgumentException if the rank is negative
     */
    public Piece(int rank, PlayerColor color) {
        if (rank < 0) {
            throw new IllegalArgumentException("The rank must be positive");
        }
        this.rank = rank;
        this.color = color;
        this.nbSteps = 1;
    }

    /**
     * Creates a Piece with a rank, a color and a number of steps that have been
     * passed in parameter.
     *
     * @param rank the rank of the piece
     * @param nbSteps the number of steps the piece can do
     * @param color the color of the piece
     * @throws IllegalArgumentException if the rank is negative
     */
    public Piece(int rank, int nbSteps, PlayerColor color) {
        if (rank < 0) {
            throw new IllegalArgumentException("rank must be positive");
        }
        if (nbSteps < 0) {
            throw new IllegalArgumentException("nbSteps must be positive");
        }
        this.rank = rank;
        this.color = color;
        this.nbSteps = nbSteps;
    }

    /**
     * Returns the rank of the piece
     *
     * @return the rank of the piece
     */
    public int getRank() {
        return rank;
    }

    /**
     * Returns the color of the piece
     *
     * @return the color of the piece
     */
    public PlayerColor getColor() {
        return color;
    }

    /**
     * Returns the number of steps that the piece can do
     *
     * @return the number of steps that the piece can do
     */
    public int getNbSteps() {
        return nbSteps;
    }

    /**
     * Checks if the current piece is strictly greater than the other one
     *
     * @param other the piece to be compared to the current piece
     * @return {@code true} if the current piece is stricly greater than the
     * other one
     */
    public boolean isStronger(Piece other) {
        return rank > other.rank;
    }

    /**
     * Checks if the current piece equals to the other one passed in parameter
     *
     * @param other the piece to be compared to the current piece
     * @return {@code true} if the pieces have the same rank
     */
    public boolean hasSameRank(Piece other) {
        return rank == other.rank;
    }

    /**
     * Returns true if the piece can cross the square passed in parameter
     *
     * A square can be crossed if it is of type land
     *
     * @param square the square to cross
     * @return {@code true} if the piece can cross the square passed in
     * parameter
     */
    public boolean canCross(Square square) {
        return square.isLand();
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
        final Piece other = (Piece) obj;
        if (this.rank != other.rank) {
            return false;
        }
        if (this.color != other.color) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, color);
    }

    @Override
    public String toString() {
        return String.valueOf(rank);
    }
}
