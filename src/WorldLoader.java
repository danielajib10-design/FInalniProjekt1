import com.google.gson.*;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class WorldLoader {

    public World load(String path) {
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

                JsonObject exits = object.getAsJsonObject("exits");
                for (String direction : exits.keySet()) {
                    String targetName = exits.get(direction).getAsString();
                    room.addExit(direction, rooms.get(targetName));
                }
            }


            String startRoomName = root.get("start").getAsString();
            return new World(rooms.get(startRoomName));

        } catch (Exception e) {
            System.out.println("Nepodařilo se načíst soubor!");
            e.printStackTrace();
            return null;
        }
    }
}
