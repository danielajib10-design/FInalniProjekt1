package Commands;

import Core.Game;

public class HintCommand implements Command {




    private Game game;

    public HintCommand(Game game) {
        this.game = game;
    }


    public void execute(String[] parameters) {
        if (!game.getPlayer().getCurrentRoom().getItems().isEmpty()) {
            System.out.println("Pokud vidíš nějaké předměty v místnosti tak je seber.");
        } else {
            System.out.println("Zkus prozkoumat okolí nebo jít do jiné místnosti.");
        }
    }
}