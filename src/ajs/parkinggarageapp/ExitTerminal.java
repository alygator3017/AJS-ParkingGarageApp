
package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class ExitTerminal implements ParkingTicketTerminalStrategy{

    private TerminalOutputTypeStrategy output;
    private ParkingAccessTicket ticketInfo;
    

    
    @Override
    public final void outputData() {   
        output = new Receipt(ticketInfo);
        output.output();
        
    }
    
    @Override
    public void ticketTransaction(ParkingAccessTicket ticket){
        ticketInfo = ticket;
        displayTransaction();
        outputData();
        
    }
    
    public void displayTransaction(){
        output = new ExitTerminalDisplayReceipt(ticketInfo);
        output.output();
    }
    
    
    public static void main(String[] args) {
        GarageNameStrategy name = new GarageName("Best Value Parking Garage");
//        ParkingAccessTicket ticket1 = new ParkingAccessTicket(new ConsoleOutput(), name, new MinMaxFeeCalculator(8));
//        ParkingAccessTicket ticket2 = new ParkingAccessTicket(new ConsoleOutput(), name, new MinNoMaxFeeCalculator(2));
        ParkingTicketTerminalStrategy dispenser = new TicketDispenserTerminal();
        ParkingTicketTerminalStrategy exit = new ExitTerminal();
        OutputStrategy output = new ConsoleOutput();
        ParkingAccessTicket ticket1 = new ParkingAccessTicket(output, name, new MinMaxFeeCalculator(8));
        ParkingAccessTicket ticket2 = new ParkingAccessTicket(output, name, new MinNoMaxFeeCalculator(2));
        
        dispenser.ticketTransaction(ticket1);
        dispenser.outputData();
        dispenser.ticketTransaction(ticket2);
        dispenser.outputData();
        
        exit.ticketTransaction(ticket1);
        
        exit.ticketTransaction(ticket2);
        
        
    }
}
