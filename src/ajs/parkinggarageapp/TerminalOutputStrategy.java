package ajs.parkinggarageapp;

/**
 *
 * @author ajSchmidt-Zimmel
 */
public interface TerminalOutputStrategy {

    public abstract void output(OutputService output) throws NullOrEmptyArgumentException;
    
}
