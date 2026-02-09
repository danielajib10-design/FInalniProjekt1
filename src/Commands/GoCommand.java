package Commands;

import Core.Game;
import Core.Room;

public class GoCommand implements Command {


    private Game game;

    public GoCommand(Game game) {
        this.game = game;
    }


    public void execute(String[] parameters) {
        if (parameters.length == 0) {
   layer(direction)) {
            game.getMap();
            game.describeCurrentRoom();
        }
    }
}