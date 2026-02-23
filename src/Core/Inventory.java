package Core;

import java.util.ArrayList;
import java.util.List;

/**
 * Třída pro inventáře hráče.
 * @author Daniel Ajib
 */
public class Inventory {

    private int capacity;
    private List<Item> items;
    /**
     * Vytvoří inventář s kapacitou dva.
     */
    public Inventory() {
        this.capacity = 2;
        this.items = new ArrayList<>();
    }

    /**
     * Přidá předmět do inventáře pokud tam je místo.
     * @param item předmět
     * @return true pokud byl přidán
     */
        public boolean addItem(Item item) {
            if (items.size() >= capacity) {
                return false;
            }
            this.items.add(item);
            return true;
        }

    public void removeItem(Item item){
        this.items.remove(item);
    }

    /**
     * Vypíše předměty v inventáři.
     */
    public void showItems(){
        if(items.isEmpty()){
            System.out.println("V inventári nemáš žádný předmět");
            return;
        }else {
            System.out.println("V inventáři máš ");
        }
        for(Item item:items){
            System.out.println(item.getName() + " " + item.getDescription());
        }
    }

    /**
     * Najde předmět podle názvu.
     * @param name název předmětu
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

}
