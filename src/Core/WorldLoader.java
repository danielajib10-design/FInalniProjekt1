package Core;

import com.google.gson.*;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class WorldLoader {

    public static World loadWorld(String path) {
        try {
            JsonObject root = JsonParser.parseReader(new FileReader(path)).getAsJsonObject();
            JsonArray roomsArray = root.getAsJsonArray("rooms");

            Map<String, Room> rooms = new HashMap<>();


            for (JsonElement e : roomsArray) {
                JsonObject object = e.getAsJsonObject();
                String name = object.get("name").getAsString();
                String description = object.get("description").getAsString();

                rooms.put(name, new Room(name, description));
            }

            for (JsonElement e : roomsArray) {
                JsonObject object = e.getAsJsonObject();
                Room room = rooms.get(object.get("name").getAsString());

                if (object.has("exits")) {
                    JsonObject exits = object.getAsJsonObject("exits");
                    for (String direction : exits.keySet()) {
                        String targetName = exits.get(direction).getAsString();
                        room.addExit(direction, rooms.get(targetName));
                    }
                }

                if (object.has("items")) {
                    JsonArray items = object.getAsJsonArray("items");
                    for (JsonElement itemElement : items) {
                        JsonObject itemObj = itemElement.getAsJsonObject();
                        String itemName = itemObj.get("name").getAsString();
                        String itemDescription = itemObj.get("description").getAsString();
                        room.addItem(new Item(itemName, itemDescription));
                    }
                }

                if (object.has("characters")) {
                    JsonArray characters = object.getAsJsonArray("characters");
                    for (JsonElement charElement : characters) {
                        JsonObject charObj = charElement.getAsJsonObject();
                        String characterName = charObj.get("name").getAsString();
                        String role = charObj.has("role") ? charObj.get("role").getAsString() : "";
                        String description = charObj.has("description") ? charObj.get("description").getAsString() : "";
                        room.addCharacter(new Character(characterName, role, description));
                    }
                }
            }

            String startRoomName = root.get("start").getAsString();
            return new World(rooms.get(startRoomName));

        } catch (Exception e) {
            System.out.println("Nepodařilo se načíst soubor: " + path);
            e.printStackTrace();
            return null;
        }
    }
}