package Commands;

import Core.Game;

public class GoCommand implements Command {


    private Game game;

    public GoCommand(Game game) {
        this.game = game;
    }


    public void execute(String[] parameters) {
        if (parameters.length == 0) {
            System.out.println("Musíš zadat směr (např. jdi sever).");
            return;
        }

        String direction = parameters[0].toLowerCase();
        if (game.movePlayer(direction)) {
            game.getMap();
            game.describeCurrentRoom();
        } else {
            System.out.println("Tímto směrem se nedá jít.");
        }
    }
}