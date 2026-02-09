package Commands;

import Core.Game;

public class HelpCommand implements Command {


    private Game game;

    public HelpCommand(Game game) {
        this.game = game;
    }


    public void execute(String[] parameters) {
        System.out.println("Dostupné příkazy:");
        System.out.println("- pomoc: zobrazí nápovědu");
        System.out.println("- objev: prozkoumá místnost");
        System.out.println("- jdi <směr>: přesun do jiné místnosti");
        System.out.println("- vem <předmět>: sebere předmět");
        System.out.println("- pouzij <předmět>: použije předmět z inventáře");
        System.out.println("- mluv <postava>: promluví s postavou");
        System.out.println("- inventar: zobrazí inventář");
        System.out.println("- napoveda: vypíše nápovědu");
        System.out.println("- konec: ukončí hru");
    }
}