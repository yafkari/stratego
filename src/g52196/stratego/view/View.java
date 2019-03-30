package g52196.stratego.view;

import g52196.stratego.model.Move;
import g52196.stratego.model.Piece;
import g52196.stratego.model.Player;
import g52196.stratego.model.PlayerColor;
import g52196.stratego.model.Square;
import java.util.List;
import java.util.Scanner;

/**
 * @author 52196
 * 
 * Is in charge of the interactions with the user
 */
public class View {
    private Scanner in;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    /**
     * Initialize the Scanner
     */
    public View() {
        in = new Scanner(System.in);
    }
    
    /**
     * Displays a message passed in parameter in cyan
     * 
     * @param message the message that will be displayed
     */
    private void info(String message) {
        System.out.println( ANSI_CYAN +
            message
        + ANSI_RESET);
    }
    
    /**
     * Displays a welcome message
     */
    public void initialize() {
        System.out.println("Welcome in Stratego\n");
    }
    
    /**
     * Displays a goodbye message
     */    
    public void quit() {
        System.out.println("See you soon !");
    }
    
    /**
     * Displays the message error passed in parameter in red
     * 
     * @param message the message that will be displayed
     */
    public void displayError(String message) {
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }
    
    /**
     * Displays the list of availabe commands
     */
    public void displayHelp() {
        info("List of available commands:");
        info("1 - Quit the game : quit");
        info("2 - Select a piece : select " 
                + ANSI_RESET + "row column");
        info("3 - See the possible moves of the selected piece : moves");
        info("4 - Apply a move by choosing the move number of the moves command : "
                + "apply " + ANSI_RESET + "number");
    }
    
    /**
     * Asks the user to choose a command
     * @return the chosen command
     */
    public String askCommand() {
        info("Please, enter a command: \n");
        
        return in.nextLine().toLowerCase();
    }
    
    /**
     * Displays the board passed in parameter
     * 
     * @param squares the board to be displayed
     */
    public void displayBoard(Square[][] squares) {
        
        System.out.print("\n Col#   ");
        for (int i = 0; i < squares[0].length; i++) {
            System.out.print("| "+i+" |");
        }
        System.out.println("\n ===========================");
        for (int i = 0; i < squares.length; i++) {
            System.out.print(" Row# " + i + " ");
            for (Square column : squares[i]) {
                if (column.isFree()) {
                    System.out.print("| * |");
                } else {
                    if (column.getPiece().getColor() == PlayerColor.BLUE) {
                        System.out.print("| " + ANSI_BLUE + column + ANSI_RESET + " |");
                    } else {
                        System.out.print("| " + ANSI_RED + column + ANSI_RESET + " |");
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
    /**
     * Indicates to the player that the game is over
     */
    public void displayOver() {
        info("GAME OVER");
    }
    
    /**
     * Displays the selected piece passed in parameter
     * 
     * @param piece the selected piece
     */
    public void displaySelected(Piece piece) {
        System.out.print(piece.getClass().getSimpleName());
    }
    
    public void displayMoves(List<Move> moves) {
        System.out.println(moves.size() + " possible move(s)");
        for (int i = 0; i < moves.size(); i++) {
            Move move = moves.get(i);
            System.out.println(i + " - " + 
                    move.getPiece() + " can move to the row " + 
                    move.getEnd().getRow() + " and the column " + 
                    move.getEnd().getColumn());
        }
    }
    
    public void displayCurrentPlayer(Player player) {
        info("It is the turn of the " + player.getColor() + " player...");
    }
}
