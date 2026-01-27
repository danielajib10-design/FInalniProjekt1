import java.util.Map;

public class CommandProcessor {

    private Map<String, Command> commands;

    public void registerCommand(String keyword, Command command);
    public void processCommand(String input);
}
