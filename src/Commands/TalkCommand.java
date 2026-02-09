package Commands;

import Core.Character;
import Core.Game;
import Core.Room;

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
        character.talk(game.getPlayer());
    }
}