import Core.World;
import Core.WorldLoader;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WorldLoaderTest {

    @Test
    void loadWorldLoadsValidJson() {
        World world = WorldLoader.loadWorld("resource/world.json");

        assertNotNull(world);
        assertNotNull(world.getStartingRoom());
        assertEquals("VstupniHala", world.getStartingRoom().getName());
    }
}