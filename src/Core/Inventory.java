package Core;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private int capacity;
    private List<Item> items;

    public Inventory() {
        this.capacity = 2;
        this.items = new ArrayList<>();
    }

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

    public boolean containsItem(Item item){
        return items.contains(item);
    }

    public List<Item> getItems(){
        return items;
    }

    public Item findItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

}
