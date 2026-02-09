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
        describeCurrentRoom();
        this.commandProcessor.run(this);
    }
    public void end(){
        this.running = false;
    }

    public void processInput(String input){
        this.commandProcessor.processCommand(input);
    }

    public boolean isRunning(){
        return running;
    }

    public World getWorld() {
        return world;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean movePlayer(String direction) {
        if (world.move(direction)) {
            player.setCurrentRoom(world.getCurrentRoom());
            return true;
        }
        return false;
    }

    public void describeCurrentRoom() {
        Room room = player.getCurrentRoom();
        System.out.println(room.getName() + ": " + room.getDescription());
        if (!room.getExits().isEmpty()) {
            System.out.println("Východy: " + String.join(", ", room.getExits().keySet()));
        }
        if (!room.getItems().isEmpty()) {
            System.out.println("Předměty:");
            for (Item item : room.getItems()) {
                System.out.println("- " + item.getName() + ": " + item.getDescription());
            }
        }
        if (!room.getCharacters().isEmpty()) {
            System.out.println("Postavy:");
            for (Character character : room.getCharacters()) {
                System.out.println("- " + character.getName() + " (" + character.getRole() + ")");
            }
        }
    }
}