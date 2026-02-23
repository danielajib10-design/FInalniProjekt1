package Core;

/**
 * Třída pro postavy ve hře.
 * @author Daniel Ajib
 */
public class Character {

    private String name;
    private String role;
    private String description;


    /**
     * Vytvoří postavu.
     * @param name jméno
     * @param role role postavy
     * @param description text dialogu/popisu
     */
    public Character(String name, String role, String description) {
        this.name = name;
        this.role = role;
        this.description = description;
    }

    public String getName(){
        return name;
    }
    public String getRole(){
        return role;
    }

    public void talk(Player player){
        System.out.println(name + ": " + description);
    }
}
