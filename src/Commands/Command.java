package Commands;

/**
 * Rozhraní pro všechny příkazy.
 * @author Daniel Ajib
 */
public interface Command {

    /**
     * Provede příkaz.
     * @param parameters parametry příkazu
     */
    void execute(String[] parameters);
}