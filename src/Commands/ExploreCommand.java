package Commands;

import Core.Game;

/**
 * Příkaz pro zobrazení detailu aktuální místnosti.
 * @author Daniel Ajib
 */
public class ExploreCommand implements Command {



    private Game game;

    /**
     * Vytvoří příkaz.
     * @param game instance hry
     */
    public ExploreCommand(Game game) {
        this.game = game;
    }

    /**
     * Provede prozkoumání místnosti.
     * @param parameters nepoužito
     */
    public void execute(String[] parameters) {
        game.describeCurrentRoom();
    }
}