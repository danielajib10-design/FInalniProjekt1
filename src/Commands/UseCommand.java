package Commands;

import Core.Game;
import Core.Inventory;
import Core.Item;

public class UseCommand implements Command {

    private Game game;

    public UseCommand(Game game) {
        this.game = game;
    }

    public void execute(String[] parameters) {
        if (parameters.length == 0) {
            System.out.println("Musíš zadat název předmětu.");
            return;
        }

        String itemName = String.join(" ", parameters);
        Inventory inventory = game.getPlayer().getInventory();
        Item item = inventory.findItemByName(itemName);
        if (item == null) {
            System.out.println("Tento předmět v inventáři nemáš.");
            return;
        }

        item.use(game.getPlayer());
        if (item.isConsumable()) {
            inventory.removeItem(item);
            System.out.println(item.getName() + " byl spotřebován.");
        }
    }
}