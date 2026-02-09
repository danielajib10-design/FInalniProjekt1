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

        String itemName = String.join(" ", parameters);
        Room room = game.getPlayer().getCurrentRoom();
        Item item = room.findItemByName(itemName);
        if (item == null) {
            System.out.println("Takový předmět tu není.");
            return;
        }
        if (item.getName().equalsIgnoreCase("Kavovar")){
            System.out.println("Kávovar nemůžeš vzít.");
            return;
        }

        if (game.getPlayer().getInventory().addItem(item)) {
            room.removeItem(item);
            System.out.println("Sebral jsi: " + item.getName());
        } else {
            System.out.println("Inventář je plný.");
        }
    }
}