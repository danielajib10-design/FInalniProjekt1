package Core;

public class Player {



    private String name;
    private String description;
    private Room currentRoom;
    private Inventory inventory;

    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
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


}
