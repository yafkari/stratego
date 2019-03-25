package g52196.stratego.controller;

import g52196.stratego.model.Model;
import g52196.stratego.view.View;

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
     * Allows to start a game
     */
    public void startGame() {
        game.start();
        view.displayHelp();
        
        while (!game.isOver()) {
            view.displayBoard(game.getBoard());
            view.askCommand();
        }
        
        view.displayOver();
    }
}
