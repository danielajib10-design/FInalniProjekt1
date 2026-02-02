package Commands;

import Core.Game;

public class ExploreCommand implements Command {



    private Game game;

    public ExploreCommand(Game game) {
        this.game = game;
    }



    @Override
    public void execute(String[] parameters, Game game) {
        return;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
