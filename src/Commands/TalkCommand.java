package Commands;

import Core.*;
import Core.Character;

import java.util.Scanner;

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
        if (character.getName().equalsIgnoreCase("Hubert")) {
            handleHubertEncounter(character, room, game.getPlayer());
            return;
        }
        if (character.getName().equalsIgnoreCase("Pan Novak")||character.getName().equalsIgnoreCase("Pan Novák")) {
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
    private void handleHubertEncounter(Character character, Room room, Player player) {
        if (!room.getName().equalsIgnoreCase("Depozitar")) {
            character.talk(player);
            return;
        }
        if (player.isHubertDefeated()) {
            System.out.println("Hubert: Už jsi mě porazil. Koruna je tvá.");
            return;
        }
        System.out.println("Hubert: Jelikož jsem si vědom tvé síly tak ti dám hádanku a kdzy ji zodpovíš správně, tak se vzdám a dám ti tu korunu.");
        System.out.println("Hádanka: Jmenuji se Ptáček, ale nejsem zvíře jaké je mé jméno");
        System.out.print("Odpověď: ");
        Scanner scr = new Scanner(System.in);
        String answer = scr.nextLine().trim().toLowerCase();
        if (!answer.equalsIgnoreCase("Ondra") && !answer.equalsIgnoreCase("Ondřej")) {
            System.out.println("Hubert: Špatně!");
            System.out.println("Protože jsi odpověděl špatně tak Hubert vzal korunu a utekl.");
            System.out.println("!!!!!!!!!Konec Hry zkus to znova!!!!!!!!!");
            game.end();
            return;
        }
        player.setHubertDefeated(true);
        Item crown = room.findItemByName("Svatovaclavska koruna");
        if (crown != null) {
            if (player.getInventory().addItem(crown)) {
                room.removeItem(crown);
                System.out.println("Hubert: Dobře, vyhrál jsi. Tady máš svatováclavskou korunu.");
            } else {
                System.out.println("Hubert: Vyhrál jsi, ale máš plný inventář. Udělej si místo a korunu si vezmi.");
            }
        } else {
            System.out.println("Hubert: Vyhrál jsi, ale korunu už nemam.");
        }
    }
}