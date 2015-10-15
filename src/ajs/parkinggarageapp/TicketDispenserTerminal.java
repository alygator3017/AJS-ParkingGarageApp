
package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class TicketDispenserTerminal implements ParkingTicketTerminalStrategy {
    
    private ParkingAccessTicket ticket;
    private final OutputStrategy output;
    

    public TicketDispenserTerminal(OutputStrategy output) {
        
        this.output = output;
    }
       
    
    //start
    @Override
    public final void ticketTransaction(ParkingAccessTicket ticket){
        
        TerminalOutputTypeStrategy ticketOutput = new TicketOutput(output, ticket);
        this.ticket = ticket;
        ticketOutput.output();
    }

    public final ParkingAccessTicket getTicket() {
        return ticket;
    }    
    
    public static void main(String[] args) {
        OutputStrategy consoleOutput = new ConsoleOutput();
        ParkingTicketTerminalStrategy dispenser = new TicketDispenserTerminal(consoleOutput);
        ParkingAccessTicket ticket1 = new ParkingAccessTicket("Herbies", new MinNoMaxFeeCalculator(8));
        dispenser.ticketTransaction(ticket1);
    }
}
