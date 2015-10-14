
package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class TicketDispenserTerminal implements ParkingTicketTerminalStrategy {
    
    private ParkingAccessTicketData ticket;
    private OutputStrategy output;
    private final TerminalOutputTypeStrategy ticketOutput = new TicketOutput(output, ticket);

    public TicketDispenserTerminal(OutputStrategy output, ParkingAccessTicketData ticket) {
        this.ticket = ticket;
        this.output = output;
    }
       
    
    //start
    @Override
    public final void ticketTransaction(){
        ticketOutput.output();
    }

    public final ParkingAccessTicketData getTicket() {
        return ticket;
    }    
    
    public static void main(String[] args) {
        ParkingTicketTerminalStrategy dispenser = new TicketDispenserTerminal(new ConsoleOutput(), new ParkingAccessTicketData(new GarageName("herbies"), new MinNoMaxFeeCalculator(8)));
        dispenser.ticketTransaction();
    }
}
