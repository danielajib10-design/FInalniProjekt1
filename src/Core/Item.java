package Core;

public class Item {

    private String name;
    private String description;
    private boolean consumable;

    public Item() {}

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.consumable = false;
    }

    public Item(String name, String description, boolean consumable) {
        this.name = name;
        this.description = description;
        this.consumable = consumable;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public boolean isConsumable() {
        return consumable;
    }

    public void use(Player player) {
        System.out.println(player.getName() + " použil předmět: " + name);
    }
}
