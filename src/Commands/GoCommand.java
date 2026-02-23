package Commands;

import Core.Game;
import Core.Room;

/**
 * Příkaz pro přesun hráče mezi místnostmi.
 * @author Daniel AJib
 */
public class GoCommand implements Command {


    private Game game;

    /**
     * Vytvoří příkaz.
     * @param game instance hry
     */
    public GoCommand(Game game) {
        this.game = game;
    }

    /**
     * Provede přesun ve zvoleném směru.
     * @param parameters směr pohybu
     */
    public void execute(String[] parameters) {
        if (parameters.length == 0) {
            System.out.println("Musíš zadat směr (např. jdi sever).");
            return;
        }

        String direction = parameters[0].toLowerCase();
        Room currentRoom = game.getPlayer().getCurrentRoom();
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom == null) {
            System.out.println("Tímto směrem se nedá jít.");
            return;
        }
        if (nextRoom.getName().equalsIgnoreCase("Depozitar")
                && game.getPlayer().getInventory().findItemByName("Univerzalni klic") == null) {
            System.out.println("Depozitář je zamčený. Potřebuješ univerzální klíč.");
            return;
        }
        if (game.movePlayer(direction)) {
            game.getMap();
            game.describeCurrentRoom();
        }
    }
}