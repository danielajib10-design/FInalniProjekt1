import Core.Character;
import Core.Item;
import Core.Room;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void findsItemAndCharacterByName() {
        Room room = new Room("Bufet", "Popis");
        room.addItem(new Item("Mince", "m"));
        room.addCharacter(new Character("Hubert", "Zloděj", "..."));

        assertNotNull(room.findItemByName("mince"));
        assertNotNull(room.findCharacterByName("HUBERT"));
        assertNull(room.findCharacterByName("Novak"));
    }
}