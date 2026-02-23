package Commands;

import Core.Game;
import Core.Inventory;
import Core.Item;
import Core.Player;
import Core.Room;

/**
 * Příkaz pro použití předmětu.
 * @author Daniel Ajib
 */
public class UseCommand implements Command {

    private Game game;

    /**
     * Vytvoří příkaz.
     * @param game instance hry
     */
    public UseCommand(Game game) {
        this.game = game;
    }

    /**
     * Provede použití předmětu z inventáře nebo interakci s předmětem v místnosti.
     * @param parameters název předmětu
     */
    public void execute(String[] parameters) {
        if (parameters.length == 0) {
            System.out.println("Musíš zadat název předmětu.");
            return;
        }

        String itemName = String.join(" ", parameters);
        Player player = game.getPlayer();
        Room room = player.getCurrentRoom();
        Inventory inventory = game.getPlayer().getInventory();
        Item item = inventory.findItemByName(itemName);
        if (item != null && item.getName().equalsIgnoreCase("Mince") && room.getName().equalsIgnoreCase("Bufet")) {
            if (!player.isCoffeeMachineRepaired()) {
                System.out.println("Kávovar je rozbitý. Nejprve ho musíš opravit.");
                return;
            }
            Item coffee = new Item(
                    "Horka kava",
                    "Předmět, který slouží jako prostředek k získání klíče od pana Nováka.",
                    true
            );
            if (!inventory.addItem(coffee)) {
                System.out.println("Inventář je plný. Nejprve si uvolni místo na kávu.");
                return;
            }
            inventory.removeItem(item);
            System.out.println("Vhodil jsi minci do kávovaru a získal horkou kávu.");
            return;
        }
        if (item == null) {
            Item roomItem = room.findItemByName(itemName);
            if (roomItem != null && roomItem.getName().equalsIgnoreCase("Kavovar")) {
                if (player.isCoffeeMachineRepaired()) {
                    System.out.println("Kávovar je opravený.");
                    return;
                }
                player.setCoffeeMachineRepaired(true);
                System.out.println("Opravil jsi kávovar. Teď můžeš použít minci.");
                return;
            }
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