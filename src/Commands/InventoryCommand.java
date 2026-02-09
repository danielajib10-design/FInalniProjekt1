package Commands;

import Core.Game;
import Core.Inventory;

public class InventoryCommand implements Command {

    private  Game game;

    public InventoryCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute(String[] parameters) {
        Inventory inventory = game.getPlayer().getInventory();
        inventory.showItems();
    }
}