package Core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Třída pro každou místnost ve hře.
 * @author Daniel AJib
 */
public class Room {

    private String name;
    private String description;
    private Map<String, Room> exits;
    private List<Item> items;
    private List<Core.Character> characters;

    /**
     * Vytvoří místnost.
     * @param name název místnosti
     * @param description popis místnosti
     */
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.exits = new HashMap<>();
        this.items = new ArrayList<>();
        this.characters = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void addExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public Map<String, Room> getExits() {
        return exits;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }


    public List<Character> getCharacters() {
        return characters;
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

    /**
     * Najde předmět podle názvu
     * @param name název
     * @return nalezený předmět nebo null
     */
    public Item findItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Najde postavu podle jména.
     * @param name jméno
     * @return nalezená postava nebo null
     */
    public Character findCharacterByName(String name) {
        for (Character character : characters) {
            if (character.getName().equalsIgnoreCase(name)) {
                return character;
            }
        }
        return null;
    }

}
