package Commands;

import Core.Game;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Zpracovává vstup od uživatele a spouští příkazy.
 * @author Daniel Ajib
 */
public class CommandProcessor {


    private final Map<String, Command> commands = new HashMap<>();
    private final Scanner scr = new Scanner(System.in);

    /**
     * Zaregistruje všechny dostupné herní příkazy.
     * @param game instance hry
     */
    public void registerCommand(Game game){
        commands.put("pomoc", new HelpCommand(game));
        commands.put("jdi", new GoCommand(game));
        commands.put("konec", new EndCommand(game));
        commands.put("objev", new ExploreCommand(game));
        commands.put("napoveda", new HintCommand(game));
        commands.put("vem", new TakeCommand(game));
        commands.put("mluv", new TalkCommand(game));
        commands.put("pouzij", new UseCommand(game));
        commands.put("inventar", new InventoryCommand(game));
        commands.put("odloz", new DropCommand(game));
    }

    /**
     * Zpracuje jeden textový příkaz.
     * @param input vstup od uživatele
     */
    public void processCommand(String input){
        if (input == null || input.isBlank()) {
            System.out.println("Zadej příkaz.");
            return;

        }
        String[] commandInput = input.trim().split(" ");
        String commandName = commandInput[0].toLowerCase();

        String[] param = new String[commandInput.length - 1];
        for(int i = 1; i < commandInput.length; i++){
            param[i - 1] = commandInput[i];
        }

        Command command = commands.get(commandName);
        if(command != null){
            command.execute(param);
        } else {
            System.out.println("Příkaz nebyl nalezen");
        }
    }

    /**
     * Spustí vstupní smyčku příkazů.
     * @param game instance hry
     */
    public void run(Game game){
        while (game.isRunning()) {
            System.out.print("> ");
            if (!scr.hasNextLine()) {
                break;
            }
            String input = scr.nextLine();
            processCommand(input);
        }
    }
}