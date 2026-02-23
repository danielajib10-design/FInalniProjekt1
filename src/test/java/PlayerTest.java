import Core.Player;
import Core.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void setCurrentRoomIgnoresNullAndKeepsOriginalRoom() {
        Room start = new Room("Start", "start room");
        Room next = new Room("Next", "next room");
        Player player = new Player(start);

        player.setCurrentRoom(next);
        assertEquals("Next", player.getCurrentRoom().getName());

        player.setCurrentRoom(null);
        assertEquals("Next", player.getCurrentRoom().getName());
    }

    @Test
    void canTogglePlayerStateFlags() {
        Player player = new Player(new Room("Start", "start room"));

        assertFalse(player.isCoffeeMachineRepaired());
        assertFalse(player.isHubertDefeated());

        player.setCoffeeMachineRepaired(true);
        player.setHubertDefeated(true);

        assertTrue(player.isCoffeeMachineRepaired());
        assertTrue(player.isHubertDefeated());
    }
}