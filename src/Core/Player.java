package Core;

public class Player {



    private String name;
    private String description;
    private Room currentRoom;
    private Inventory inventory;
    private boolean coffeeMachineRepaired;

    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
        this.inventory = new Inventory();
        this.name = "Adam";
        this.coffeeMachineRepaired = false;
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }
    public void setCurrentRoom(Room room){
        this.currentRoom = room;
    }
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


}
