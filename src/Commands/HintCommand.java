package Commands;

import Core.Game;

/**
 * Příkaz pro jednoduchou kontextovou nápovědu.
 * @author Daniel Ajib
 */
public class HintCommand implements Command {


    private Game game;

    /**
     * Vytvoří příkaz.
     * @param game instance hry
     */
    public HintCommand(Game game) {
        this.game = game;
    }


    /**
     * Vypíše nápovědu podle stavu aktuální místnosti.
     * @param parameters nepoužito
     */
    public void execute(String[] parameters) {
        if (!game.getPlayer().getCurrentRoom().getItems().isEmpty()) {
            System.out.println("Pokud vidíš nějaké předměty v místnosti tak je seber.");
        } else {
            System.out.println("Zkus prozkoumat okolí nebo jít do jiné místnosti.");
        }
    }
}