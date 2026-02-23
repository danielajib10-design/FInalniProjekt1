import Core.Room;
import Core.World;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WorldTest {

    @Test
    void moveChangesCurrentRoomOnValidDirection() {
        Room a = new Room("A", "a");
        Room b = new Room("B", "b");
        a.addExit("sever", b);
        World world = new World(a);

        assertTrue(world.move("sever"));
        assertEquals("B", world.getCurrentRoom().getName());
    }

    @Test
    void moveReturnsFalseOnInvalidDirection() {
        Room a = new Room("A", "a");
        World world = new World(a);

        assertFalse(world.move("jih"));
        assertEquals("A", world.getCurrentRoom().getName());
    }
}