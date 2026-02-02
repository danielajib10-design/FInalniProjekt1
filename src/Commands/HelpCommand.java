package Commands;

import Core.Game;

public class HelpCommand implements Command {



    private Game game;

    public HelpCommand(Game game) {
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
