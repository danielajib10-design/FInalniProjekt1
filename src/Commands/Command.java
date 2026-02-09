package Commands;

import Core.Game;


public interface Command {

    void execute(String[] parameters, Game game);
}
