package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class TicketDispenserTerminal implements ParkingTicketTerminalStrategy {
    private final Output ticketOutput;
    
    public TicketDispenserTerminal(Output ticketOutput){
        this.ticketOutput = ticketOutput;
    }
    public void newTicket(String garageName, int carID, double hours, double fee, String date) {
        ticketTransaction(garageName, carID, hours, fee, date);
        
    }
       
    @Override
    public final void ticketTransaction(String garageName, int carID, double hours, double fee, String date) {
        TerminalOutputTypeStrategy dataOutput = new TicketDataOutput(garageName, carID, date);
        dataOutput.output(ticketOutput);
    }   
}
