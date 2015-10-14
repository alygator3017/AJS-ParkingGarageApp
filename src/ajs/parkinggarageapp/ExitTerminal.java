
package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class ExitTerminal implements ParkingTicketTerminalStrategy{

    
    private ParkingAccessTicketData ticketInfo;
    private final TerminalOutputTypeStrategy outputReceipt = new Receipt(ticketInfo);
    private final TerminalOutputTypeStrategy outputDisplay = new ExitTerminalDisplayReceipt(ticketInfo);
    

    
    @Override
    public final void outputData() {   
        outputReceipt.output();
        
    }
    
    @Override
    public void ticketTransaction(ParkingAccessTicketData ticket){
        ticketInfo = ticket;
        displayTransaction();
        outputData();
        
    }
    
    public void displayTransaction(){
        outputDisplay.output();
    }
    
    
    public static void main(String[] args) {
        GarageNameStrategy name = new GarageName("Best Value Parking Garage");
//        ParkingAccessTicketData ticket1 = new ParkingAccessTicketData(new ConsoleOutput(), name, new MinMaxFeeCalculator(8));
//        ParkingAccessTicketData ticket2 = new ParkingAccessTicketData(new ConsoleOutput(), name, new MinNoMaxFeeCalculator(2));
        ParkingTicketTerminalStrategy dispenser = new TicketDispenserTerminal();
        ParkingTicketTerminalStrategy exit = new ExitTerminal();
        OutputStrategy output = new ConsoleOutput();
        ParkingAccessTicketData ticket1 = new ParkingAccessTicketData(output, name, new MinMaxFeeCalculator(8));
        ParkingAccessTicketData ticket2 = new ParkingAccessTicketData(output, name, new MinNoMaxFeeCalculator(2));
        
        dispenser.ticketTransaction(ticket1);
        dispenser.outputData();
        dispenser.ticketTransaction(ticket2);
        dispenser.outputData();
        
        exit.ticketTransaction(ticket1);
        
        exit.ticketTransaction(ticket2);
        
        
    }
}
