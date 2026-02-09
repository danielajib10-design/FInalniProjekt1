package Commands;

import Core.Game;
import Core.Item;
import Core.Room;

public class TakeCommand implements Command {


    private Game game;


    public TakeCommand(Game game) {
        this.game = game;
    }


    public void execute(String[] parameters) {
        if (parameters.length == 0) {
            System.out.println("Musíš zadat název předmětu.");
            return;
        }

        String itemName = String.join(
    }
}