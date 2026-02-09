package Core;

public class Character {

    private String name;
    private String role;
    private String description;

    public Character() {}

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
    public String getDescription(){
        return description;
    }

    public void talk(Player player){
        System.out.println(name + ": " + description);
    }
}
