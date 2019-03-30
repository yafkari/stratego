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
    
    /**
     * Creates a Piece with a rank and a color that
     * have been passed in parameter.
     * 
     * @param rank the rank of the piece
     * @param color the color of the piece
     * @throws IllegalArgumentException if the rank is negative
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
    
    /**
     * @return the color of the piece
     */
    public PlayerColor getColor() {
        return color;
    }
    
    /**
     * Checks if the current piece is 
     * strictly greater than the other one
     * 
     * @param other the piece to be compared to the current piece
     * @return true if the current piece is stricly greater 
     * than the other one, else false
     */
    public boolean isStronger(Piece other) {
        return rank > other.rank;
    }
    
    /**
     * Checks if the current piece equals 
     * to the other one passed in paramater
     * 
     * @param other the piece to be compared to the current piece
     * @return true if the pieces have the same rank, else false
     */
    public boolean hasSameRank(Piece other) {
        return rank == other.rank;
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
        int hash = 3;
        hash = 41 * hash + this.rank;
        hash = 41 * hash + Objects.hashCode(this.color);
        return hash;
    }

    @Override
    public String toString() {
        return String.valueOf(rank);
    }
}
