import Core.Inventory;
import Core.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @Test
    void addItemRespectsCapacity() {
        Inventory inventory = new Inventory();
        assertTrue(inventory.addItem(new Item("A", "a")));
        assertTrue(inventory.addItem(new Item("B", "b")));
        assertFalse(inventory.addItem(new Item("C", "c")));
    }

    @Test
    void findItemByNameIsCaseInsensitive() {
        Inventory inventory = new Inventory();
        Item key = new Item("Univerzalni klic", "klic");
        inventory.addItem(key);

        assertNotNull(inventory.findItemByName("univerzalni klic"));
        assertNull(inventory.findItemByName("neexistuje"));
    }
}