package Commands;

import Core.Game;

public class EndCommand implements Command {

    private Game game;

    public EndCommand(Game game) {
        this.game = game;
    }

    public void execute(String[] parameters){
        System.out.println("Hra byla ukončena.");
        game.end();
    }
}