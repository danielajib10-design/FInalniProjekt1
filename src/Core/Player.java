package Core;

public class Player {



    private String name;
    private String description;
    private Room currentRoom;
    private Inventory inventory;

    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
        this.inventory = new Inventory();
        this.name = "Adam";
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

}
