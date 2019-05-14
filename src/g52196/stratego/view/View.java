package g52196.stratego.view;

import g52196.stratego.model.Move;
import g52196.stratego.model.Piece;
import g52196.stratego.model.Player;
import g52196.stratego.model.PlayerColor;
import g52196.stratego.model.Square;
import java.util.ArrayList;
import java.util.Arrays;
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
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";

    /**
     * Initialize the Scanner
     */
    public View() {
        in = new Scanner(System.in);
    }

    /**
     * Displays a message passed in parameter in blue
     *
     * @param message the message that will be displayed
     */
    private void info(String message) {
        System.out.println(ANSI_BLUE
                + message
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
     * Displays the list of available commands
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
     *
     * @return the chosen command
     */
    public String askCommand() {
        info("Please, enter a command:");

        return in.nextLine().toLowerCase();
    }

    /**
     * Displays the board passed in parameter
     *
     * @param squares the board to be displayed
     * @param currentColor the color of the current player
     */
    public void displayBoard(Square[][] squares, PlayerColor currentColor) {
        displayHeaderBoard(squares.length);

        for (int i = 0; i < squares.length; i++) {
            System.out.print(" Row# 0" + i + " ");
            for (Square column : squares[i]) {
                displaySquare(column, currentColor);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void displaySquare(Square square, PlayerColor color) {
        if (square.isFree()) {
            if (square.isLand()) {
                System.out.print("| " + ANSI_GREEN_BACKGROUND + "  "
                        + ANSI_RESET + " |");
            } else {
                System.out.print("| " + ANSI_CYAN_BACKGROUND + "  "
                        + ANSI_RESET + " |");
            }
        } else {
            if (square.getPiece().getColor() == color) {
                System.out.print("| " + ANSI_GREEN_BACKGROUND
                        + (square.getPiece().getColor() == PlayerColor.BLUE
                        ? ANSI_BLUE : ANSI_RED)
                        + getSquareName(square.getPiece().getRank())
                        + ANSI_RESET + " |");
            } else {
                System.out.print("| " + ANSI_GREEN_BACKGROUND
                        + (square.getPiece().getColor() == PlayerColor.BLUE
                        ? ANSI_BLUE : ANSI_RED) + "??" + ANSI_RESET + " |");

            }
        }
    }

    /**
     * Returns the name of a piece by looking to the rank
     *
     * @param rank the rank of the piece
     * @return the name of the piece with the rank passed in parameter
     */
    private String getSquareName(int rank) {
        String[] squareNames = {"FL", "SP", "PA", "DE", "PE", "PE", "PE", "PE",
            "PE", "GE", "MA", "BO"};

        return squareNames[rank];
    }

    /**
     * Displays the header of the board
     *
     * @param size the number of columns to be displayed
     */
    public void displayHeaderBoard(int size) {
        System.out.print("\n Col#    ");
        for (int i = 0; i < size - 1; i++) {
            System.out.print("| 0" + i + " |");
        }
        System.out.println("\n ======================================");
    }

    /**
     * Indicates to the players that the game is over if there is winners
     *
     * @param winners the winners of the game
     */
    public void displayOver(List<Player> winners) {
        info("GAME OVER");

        if (winners != null) {
            info("Congratulations");
            for (Player player : winners) {
                System.out.println("The "
                        + player.getColor().name().toLowerCase()
                        + " player wins !");
            }
        }
    }

    /**
     * Displays the selected piece passed in parameter
     *
     * @param piece the selected piece
     */
    public void displaySelected(Piece piece) {
        System.out.print(piece.getClass().getSimpleName());
    }

    /**
     * Displays the possible moves of a piece
     *
     * @param moves the moves to be displayed
     */
    public void displayMoves(List<Move> moves) {
        System.out.println(moves.size() + " possible move(s)");
        for (int i = 0; i < moves.size(); i++) {
            Move move = moves.get(i);
            System.out.println(i + " - "
                    + move.getPiece() + " can move to the row "
                    + move.getEnd().getRow() + " and the column "
                    + move.getEnd().getColumn());
        }
    }

    /**
     * Indicates if it is the turn of the red or blue player
     *
     * @param player the player to whom it is the turn
     */
    public void displayCurrentPlayer(Player player) {
        info("It is the turn of the " + player.getColor() + " player...");
    }
}
