public class World {

    private Room startingRoom;
    private Room currentRoom;

    public World(Room startingRoom) {
        this.startingRoom = startingRoom;
        this.currentRoom = startingRoom;
    }

    public Room getStartingRoom() {
        return startingRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public boolean move(String direction) {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            return true;
        }
        return false;
    }


}
