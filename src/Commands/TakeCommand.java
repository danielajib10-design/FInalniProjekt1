package Commands;

import Core.Game;

public class TakeCommand implements Command {


    private Game game;

    public TakeCommand(Game game) {
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
