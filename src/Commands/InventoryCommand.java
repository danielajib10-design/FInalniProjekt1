package Commands;

import Core.Game;
import Core.Inventory;

/**
 * Příkaz pro zobrazení inventáře hráče.
 * @author Daniel Ajib
 */
public class InventoryCommand implements Command {

    private  Game game;
    /**
     * Vytvoří příkaz.
     * @param game instance hry
     */
    public InventoryCommand(Game game) {
        this.game = game;
    }

    /**
     * Provede výpis inventáře.
     * @param parameters nepoužito
     */
    public void execute(String[] parameters) {
        Inventory inventory = game.getPlayer().getInventory();
        inventory.showItems();
    }
}