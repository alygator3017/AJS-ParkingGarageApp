package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public interface TerminalOutputTypeStrategy {

    public abstract void output(Output output) throws IllegalArgumentException;
    
}
