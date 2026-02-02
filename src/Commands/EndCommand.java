package Commands;

import Core.Game;

public class EndCommand implements Command {



    private Game game;

    public EndCommand(Game game) {
        this.game = game;
    }



    @Override
    public void execute(String[] parameters, Game game){
        return;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
