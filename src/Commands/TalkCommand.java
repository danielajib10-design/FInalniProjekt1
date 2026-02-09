package Commands;

import Core.Character;
import Core.Game;
import Core.Room;

public class TalkCommand implements Command {



    private Game game;


    public TalkCommand(Game game) {
        }
        character.talk(game.getPlayer());
    }
}