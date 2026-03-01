package Core;

import Commands.CommandProcessor;

/**
 * Třída řídicí celý průběh hry.
 * Stará se o spuštění, stav hry, pohyb hráče a vykreslení informací o světě.
 * @author Daniel Ajib
 */
public class Game {


    private World world;
    private Player player;
    private CommandProcessor commandProcessor;
    private boolean running;

    /**
     * Spustí hru, načte svět, zaregistruje příkazy a začne herní smyčku.
     */
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
        System.out.println();
        System.out.println("Adam nastupuje na svou první samostatnou směnu jako bezpečnostní pracovník v Muzeu Starých časů.");
        System.out.println("Během půlnoční obchůzky ale zjistí, že nejcennější exponát, Svatováclavská koruna, zmizel a vitrína je rozbitá.");
        System.out.println("Okamžitě se spustí nouzový protokol a všechny východy se uzavřou. Adam ví, že pokud korunu nenajde, stane se hlavním podezřelým.");
        System.out.println("Brzy navíc zjišťuje, že v budově není sám. Další lidé, kteří tu zůstali uvěznění, mohou mít informace, které mu pomohou odhalit zloděje.");
        System.out.println();
        System.out.println("Bež za Paní Černou ta ti poradí co dělat");
        System.out.println();

        getMap();
        describeCurrentRoom();
        this.commandProcessor.run(this);
    }
    public void end(){
        this.running = false;
    }


    public boolean isRunning(){
        return running;
    }

     /**
     * Vypíše mapu muzea.
     */
    public void getMap(){
        System.out.println("Mapa: ");
        System.out.println("        [ Dílna ] -------- [ Archiv ] -------- [ Depozitář ]\n" +
                "            |                   |                   |\n" +
                "            |                   |                   |\n" +
                "        [ Bufet ] -------- [ Chodba ] -------- [ Hlavní sál ]\n" +
                "                                |                   |\n" +
                "                                |                   |\n" +
                "                          [ Vstupní hala ] ---- [ Šatna ]");
    }


    public Player getPlayer() {
        return player;
    }

    /**
     * Pokusí se přesunout hráče do sousední místnosti podle směru.
     * @param direction směr pohybu
     * @return true pokud se přesun povedl
     */
    public boolean movePlayer(String direction) {
        if (world.move(direction)) {
            player.setCurrentRoom(world.getCurrentRoom());
            return true;
        }
        return false;
    }

    /**
     * Vypíše detail aktuální místnosti včetně východů, předmětů a postav.
     */
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