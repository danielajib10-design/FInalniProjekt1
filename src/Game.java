public class Game {

    private World world;
    private Player player;
    private CommandProcessor commandProcessor;
    private boolean running;

    public void start();
    public void end();
    public void processInput(String input);
    public boolean isRunning();
}
