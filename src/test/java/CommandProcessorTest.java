import Commands.CommandProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandProcessorTest {

    @Test
    void processCommandHandlesNullBlankAndUnknownInput() {
        CommandProcessor processor = new CommandProcessor();

        assertDoesNotThrow(() -> processor.processCommand(null));
        assertDoesNotThrow(() -> processor.processCommand("   "));
        assertDoesNotThrow(() -> processor.processCommand("neznamyPrikaz"));
    }
}