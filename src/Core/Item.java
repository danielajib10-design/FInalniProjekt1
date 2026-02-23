package Core;

/**
 * Reprezentuje předmět ve hře.
 * @author Daniel Ajib
 */
public class Item {

    private String name;
    private String description;
    private boolean consumable;
    /**
     * Vytvoří předmět který nezmizí.
     * @param name název předmětu
     * @param description popis předmětu
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.consumable = false;
    }

    /**
     * Vytvoří předmět který po použití zmizí.
     * @param name název předmětu
     * @param description popis předmětu
     * @param consumable zda je předmět spotřebovatelný
     */
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
