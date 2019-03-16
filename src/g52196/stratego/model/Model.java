package g52196.stratego.model;

/**
 * Model of Stratego.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Facade_pattern">
 Model pattern
 </a>
 * @see
 * <a href="https://fr.wikipedia.org/wiki/Fa%C3%A7ade_(patron_de_conception)">
 * Façade (patron de conception)
 * </a>
 * @author EsiProf
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
}
