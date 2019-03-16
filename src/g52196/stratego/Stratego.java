package g52196.stratego;

import g52196.stratego.controller.Controller;
import g52196.stratego.model.Game;
import g52196.stratego.model.Model;
import g52196.stratego.view.View;

/**
 * @author 52196
 *
 * The main of the game
 */
public class Stratego {
    public static void main(String[] args) {
        Model game = new Game();
        View view = new View();
        
        Controller controller = new Controller(game, view);
        controller.initialize();
        controller.startGame();
    }
}
