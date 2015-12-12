package ajs.parkinggarageapp;

/**
 * Terminal Output Strategy Interface.
 * Connected with TicketDataOutput and ReceiptOutput.
 * @author ajSchmidt-Zimmel
 * @version 1.2
 */
public interface TerminalOutputStrategy {

    public abstract void output(OutputService output) throws NullOrEmptyArgumentException;
    
}
