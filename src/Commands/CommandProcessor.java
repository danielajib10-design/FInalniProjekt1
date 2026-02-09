package Commands;

import Core.Game;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandProcessor {


    private final Map<String, Command> commands = new HashMap<>();
    private final Scanner scr = new Scanner(System.in);

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


    public void processCommand(String input){
        String[] commandInput = input.trim().split(" ");
        if(commandInput.length == 0 || commandInput[0].isEmpty()){
            return;
        }
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