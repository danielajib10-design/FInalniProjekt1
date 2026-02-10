package Commands;

import Core.Game;
import Core.Inventory;
import Core.Item;
import Core.Room;

public class DropCommand implements Command{

    private Game game;

    public DropCommand(Game game) {
        this.game = game;
    }

    public void execute(String[] parameters){
        if(parameters.length == 0){
            System.out.println("Musíš zadat nayev předmětu.");
            return;
        }

        String itemName = String.join(" ", parameters);
        Inventory inventory = game.getPlayer().getInventory();
        Item item = inventory.findItemByName(itemName);
        if (item == null) {
            System.out.println("Tento předmět v inventáři nemáš.");
            return;
        }

        inventory.removeItem(item);
        Room room = game.getPlayer().getCurrentRoom();
        room.addItem(item);
        System.out.println("Položil jsi: " + item.getName());
        if (item.getName().equals("Svatovaclavska koruna")&& room.getName().equalsIgnoreCase("HlavniSal")){
            System.out.println("Korunu jsi uložil zpět na originální místo a tím jsi zachránil svoji pozici.");
            System.out.println("!!!!!!!VZHRÁL JSI!!!!!!!");
            game.end();
        }else {
            System.out.println("Svatováclavskou korunu musíš odložit zpátky do Hlavního Sálu.");
        }

    }
    }

