import java.util.List;

public class Inventory {

    private int capacity;
    private List<Item> items;

    public boolean addItem(Item item);
    public void removeItem(Item item);
    public boolean containsItem(String itemName);
    public List<Item> getItems();
}
