package Commands;

import Core.Game;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandProcessor {

    private Map<String, Command> commands = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public void registerCommand(Game game){
        commands.put("help", new HelpCommand(game));
        commands.put("go", new GoCommand(game));
        commands.put("end", new EndCommand(game));
        commands.put("explore", new ExploreCommand(game));
        commands.put("hint", new HintCommand(game));
        commands.put("take", new TakeCommand(game));
        commands.put("talk", new TalkCommand(game));
        commands.put("use", new UseCommand(game));
    }


    public void processCommand(String input, Game game){
        String[] commandInput = input.split(" ");
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
            command.execute(param, game);
        }else {
            System.out.println("Příkaz nebyl nalezen");
        }
    }

}
