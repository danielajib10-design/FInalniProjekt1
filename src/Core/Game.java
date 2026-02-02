package Core;

import Commands.CommandProcessor;

public class Game {


    private World world;
    private Player player;
    private CommandProcessor commandProcessor;
    private boolean running;

    public void start() {

        WorldLoader worldLoader = new WorldLoader();

        this.world = worldLoader.loadWorld("resource/world.json");

        if (this.world != null) {
            this.player = new Player(world.getStartingRoom());

        }

        this.commandProcessor = new CommandProcessor();
        this.commandProcessor.registerCommand(this);

        this.running = true;

        System.out.println("Data byla úspěšně načtena. Hra začíná!");
    }
    public void end(){

    }

    public void processInput(String input){
    }

    public boolean isRunning(){
        return running;
    }
}
