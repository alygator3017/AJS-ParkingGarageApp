
package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class TicketDispenserTerminal implements ParkingTicketTerminalStrategy {
    
    private ParkingAccessTicket ticket;
       
    
    //start
    @Override
    public final void ticketTransaction(ParkingAccessTicket newTicket){
        ticket = newTicket;
    }
    //dispense ticket (output)
    @Override
    public final void outputData(){
        ticket.printTicket();
    }

    public final ParkingAccessTicket getTicket() {
        return ticket;
    }    
    
    
    public static void main(String[] args) {
        
        
    }
}
