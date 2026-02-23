package Core;

/**
 * Třída pro hráče a jeho herní stav.
 * @author Daniel Ajib
 */
public class Player {


    private String name;
    private String description;
    private Room currentRoom;
    private Inventory inventory;
    private boolean coffeeMachineRepaired;
    private boolean hubertDefeated;

    /**
     * Vytvoří hráče v první místnosti.
     * @param currentRoom aktuální místnost hráče
     */
    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
        this.inventory = new Inventory();
        this.name = "Adam";
        this.coffeeMachineRepaired = false;
        this.hubertDefeated = false;
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }
    public void setCurrentRoom(Room room) {
        if (room != null) {
            this.currentRoom = room;
        }}
    public Inventory getInventory(){
        return inventory;
    }

    public String getName() {
        return name;
    }

    public boolean isCoffeeMachineRepaired() {
        return coffeeMachineRepaired;
    }

    public void setCoffeeMachineRepaired(boolean coffeeMachineRepaired) {
        this.coffeeMachineRepaired = coffeeMachineRepaired;
    }

    public boolean isHubertDefeated() {
        return hubertDefeated;
    }

    public void setHubertDefeated(boolean hubertDefeated) {
        this.hubertDefeated = hubertDefeated;
    }
}
