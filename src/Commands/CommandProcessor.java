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
    }


        }
    }

}