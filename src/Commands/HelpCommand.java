package Commands;

import Core.Game;

/**
 * Příkaz pro výpis nápovědy.
 * @author Daniel Ajib
 */
public class HelpCommand implements Command {

    private Game game;

    /**
     * Vytvoří příkaz.
     * @param game instance hry
     */
    public HelpCommand(Game game) {
        this.game = game;
    }

    /**
     * Vypíše dostupné příkazy.
     * @param parameters nepoužito
     */
    public void execute(String[] parameters) {
        System.out.println("Dostupné příkazy:");
        System.out.println("pomoc: zobrazí nápovědu");
        System.out.println("objev: prozkoumá místnost");
        System.out.println("jdi <směr>: přesun do jiné místnosti");
        System.out.println("vem <předmět>: sebere předmět");
        System.out.println("pouzij <předmět>: použije předmět z inventáře");
        System.out.println("odloz <předmět>: odloží předmět do místnosti a odebere ho z inventáře");
        System.out.println("mluv <postava>: promluví s postavou");
        System.out.println("inventar: zobrazí inventář");
        System.out.println("napoveda: vypíše nápovědu");
        System.out.println("konec: ukončí hru");

    }
}