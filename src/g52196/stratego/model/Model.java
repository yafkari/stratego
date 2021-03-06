package g52196.stratego.model;

import java.util.List;

/**
 * Model of Stratego.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Facade_pattern">
 * Model pattern
 * </a>
 * @see
 * <a href="https://fr.wikipedia.org/wiki/Fa%C3%A7ade_(patron_de_conception)">
 * Façade (patron de conception)
 * </a>
 * @author EsiProf, 52196
 */
public interface Model {

    /**
     * Initializes the stratego game with a default board.
     */
    void initialize();

    /**
     * Checks if a match can start.
     *
     * @throws IllegalStateException if no board is set.
     * @throws IllegalStateException if the board set is incomplete.
     */
    void start();

    /**
     * Declares if it's the end of the game.
     *
     * @return true if it's the end of the game.
     */
    boolean isOver();

    /**
     * Returns the board.
     *
     * @return the board.
     */
    Square[][] getBoard();

    /**
     * Allows the user to select a piece
     *
     * @param row the row where the piece is located
     * @param column the column where the piece is located
     * @throws IllegalArgumentException if the position is not on the board
     * @throws IllegalArgumentException if the square at the position is empty
     * @throws IllegalArgumentException if the square is not owned by the player
     */
    void select(int row, int column);

    /**
     * @return the selected piece
     * @throws NullPointerException if the selected piece is empty
     */
    Piece getSelected();

    /**
     * @return the list of possible moves
     * @throws NullPointerException if the selected piece is null
     */
    List<Move> getMoves();

    /**
     * Allows the user to apply a movement to a piece
     *
     * @param move the movement to be applied
     * @throws NullPointerException if the move passed in parameter is null
     * @throws IllegalArgumentException if the move is not valid
     */
    void apply(Move move);

    /**
     * Returns the current player
     *
     * @return the current player
     */
    Player getCurrent();

    /**
     * Returns the list of winners
     *
     * @return the list of winners
     * @throws IllegalStateException if the game is not over
     */
    List<Player> getWinners();
}
