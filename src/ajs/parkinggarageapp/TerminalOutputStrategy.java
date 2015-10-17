package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public interface TerminalOutputStrategy {

    public abstract void output(Output output) throws IllegalArgumentException;
    
}
