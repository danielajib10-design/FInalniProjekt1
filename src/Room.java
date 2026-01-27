import java.util.List;
import java.util.Map;

public class Room {

    private String name;
    private String description;
    private Map<String, Room> exits;
    private List<Item> items;
    private List<Character> characters;

    public String getName();
    public String getDescription();

    public void addExit(String direction, Room room);
    public Room getExit(String direction);

    public void addItem(Item item);
    public void removeItem(Item item);

    public List<Item> getItems();
    public List<Character> getCharacters();
}
