package Core;

/**
 * Třída pro herní svět a aktuální pozici hráče v něm.
 * @author Daniel Ajib
 */
public class World {

    private Room startingRoom;
    private Room currentRoom;

    /**
     * Vytvoří svět s první místností.
     * @param startingRoom první místnost
     */
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


    /**
     * Pokud to jde přesune hráče do místnosti v daném směru.
     * @param direction směr pohybu
     * @return true pokud se přesun podařil
     */
    public boolean move(String direction) {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            return true;
        }
        return false;
    }
}
