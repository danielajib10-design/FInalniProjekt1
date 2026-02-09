package Commands;

import Core.Game;

public class ExploreCommand implements Command {



    private Game game;

    public ExploreCommand(Game game) {
        this.game = game;
    }


    public void execute(String[] parameters) {
        game.describeCurrentRoom();
    }
}