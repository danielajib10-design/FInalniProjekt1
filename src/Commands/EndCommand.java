package Commands;

import Core.Game;

/**
 * Příkaz pro ukončení hry.
 * @author Daniel Ajib
 */
public class EndCommand implements Command {

    private Game game;

    /**
     * Vytvoří příkaz.
     * @param game instance hry
     */
    public EndCommand(Game game) {
        this.game = game;
    }

    /**
     * Provede ukončení hry.
     * @param parameters nepoužito
     */
    public void execute(String[] parameters){
        System.out.println("Hra byla ukončena.");
        game.end();
    }
}