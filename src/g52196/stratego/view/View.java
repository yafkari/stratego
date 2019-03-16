package g52196.stratego.view;

import g52196.stratego.model.Square;
import java.util.Scanner;
// TODO
/**
 * @author 52196
 * 
 */
public class View {
    private Scanner in;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    
    /**
     * Constructor
     * 
     * Initialize the Scanner
     */
    View() {
        in = new Scanner(System.in);
    }
    
    /**
     * Displays a message passed in parameter in cyan
     * 
     * @param message the message to be displayed
     */
    private void info(String message) {
        System.out.println( ANSI_CYAN +
            message
        + ANSI_RESET);
    }
    /**
     * Displays a welcome message
     */
    void initialize() {
        System.out.println("Welcome in Stratego");
    }
    /**
     * Displays a goodbye message
     */    
    void quit() {
        System.out.println("See you soon !");
    }
    
    /**
     * Displays the message error passed in parameter in red
     * 
     * @param message the message to be displayed
     */
    void displayError(String message) {
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }
    
    /**
     * Displays the list of command available
     */
    void displayHelp() {
        info("List of available commands\n1 - Quit");
    }
    
    /**
     * Asks the user to choose a comamand
     * @return the chosen command
     */
    String askCommand() {
        info("Please, choose one of the following commands:\n\n");
        displayHelp();
        
        return in.nextLine().toLowerCase();
    }
    
    /**
     * Displays the board passed in parameter
     * 
     * @param squares the board to be displayed
     */
    void displayBoard(Square[][] squares) {
        for (Square[] row : squares) {
            for (Square column : row) {
                System.out.print(column);
            }
            System.out.println();
        }
    }
    
    /**
     * Indicates to the player that the game is over
     */
    void displayOver() {
        info("GAME OVER");
    }
}
