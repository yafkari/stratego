package g52196.stratego.controller;

import g52196.stratego.model.Model;
import g52196.stratego.model.Move;
import g52196.stratego.view.View;
import java.util.ArrayList;

/**
 * @author 52196
 *
 * Takes care of the dynamics of the game
 */
public class Controller {

    private Model game;
    private View view;

    /**
     * Initialize the attributes game and view
     *
     * @param game the current game
     * @param view the current view
     * @throws NullPointerException if the game or the view is null
     */
    public Controller(Model game, View view) {
        if (game == null || view == null) {
            throw new NullPointerException("The game and the view can't be null !");
        }
        this.game = game;
        this.view = view;
    }

    /**
     * Initialize the game by initializing the view and the game
     */
    public void initialize() {
        game.initialize();
        view.initialize();
    }

    /**
     * Start the game and handle the commands
     */
    public void startGame() {
        game.start();
        view.displayHelp();

        while (!game.isOver()) {
            view.displayBoard(game.getBoard());
            view.displayCurrentPlayer(game.getCurrent());
            String command = view.askCommand();

            if (command.equalsIgnoreCase("moves")) {
                try {
                    game.getSelected();
                    view.displayMoves(game.getMoves());
                } catch (NullPointerException e) {
                    System.out.println("You have not selected a piece yet !");
                    System.out.println("Please retry");
                }
            }
            if (command.length() > 9 && command.substring(0, 6).equalsIgnoreCase("select")) {
                String row = command.substring(7, 8);
                String column = command.substring(9, 10);

                try {
                    game.select(Integer.parseInt(row), Integer.parseInt(column));
                    view.displaySelected(game.getSelected());
                    System.out.println(" is selected");
                } catch (NumberFormatException err) {
                    System.out.println("Please enter numbers !");
                    System.out.println("Example: select 1 2");
                } catch (IllegalArgumentException err) {
                    System.out.println("You are trying to select a piece that is not yours");
                }
            }
            if (command.length() > 6 && command.substring(0, 5).equalsIgnoreCase("apply")) {
                try {
                    int number = Integer.parseInt(command.substring(6, 7));
                    game.apply(game.getMoves().get(number));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            if (command.equalsIgnoreCase("quit")) {
                view.displayOver(new ArrayList<>());
                System.exit(0);
            }
        }
        view.displayOver(game.getWinners());
    }
}
