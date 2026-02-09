package Commands;

import Core.*;
import Core.Character;

public class TalkCommand implements Command {



    private Game game;


    public TalkCommand(Game game) {
        this.game = game;
    }

    public void execute(String[] parameters) {
        if (parameters.length == 0) {
            System.out.println("Musíš zadat jméno postavy.");
            return;
        }

        String characterName = String.join(" ", parameters);
        Room room = game.getPlayer().getCurrentRoom();
        Character character = room.findCharacterByName(characterName);
        if (character == null) {
            System.out.println("Taková postava tu není.");
            return;
        }
        if (character.getName().equalsIgnoreCase("Pan Novák")) {
            Inventory inventory = game.getPlayer().getInventory();
            Item coffee = inventory.findItemByName("Horka kava");
            Item key = inventory.findItemByName("Univerzalni klic");
            if (key != null) {
                System.out.println("Pan Novák: Klíč jsi už dostal.");
                return;
            }
            if (coffee == null) {
                System.out.println("Pan Novák: Kdzž mi přineseš horkou kávu dám ti za to klíč.");
                return;
            }
            inventory.removeItem(coffee);
            Item universalKey = new Item(
                    "Univerzalni klic",
                    "Předmět, který Adam získá od pana Nováka jako odměnu za  horkou kávu. Tento klíč je nutný pro odemknutí depozitáře.",
                    true);

            if (!inventory.addItem(universalKey)) {
                System.out.println("Inventář je plný. Nejprve si uvolni místo na klíč.");
                inventory.addItem(coffee);
                return;
            }
            System.out.println("Pan Novák: Díky za kávu! Tady máš univerzální klíč.");
            return;
        }
        character.talk(game.getPlayer());
    }
}