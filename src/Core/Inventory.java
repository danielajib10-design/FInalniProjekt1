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

    public void addItem(Item item){
        this.items.add(item);
    }

    public void removeItem(Item item){
        this.items.remove(item);
    }

    public void showItems(){
        if(items.isEmpty()){
            System.out.println("V inventári nemáš žádný předmět");
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



}
