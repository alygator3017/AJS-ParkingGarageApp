
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

//    public static void main(String[] args) {
//        ParkingAccessTicket car1 = new ParkingAccessTicket("Herbies", new FeeCalculator(new MinNoMaxFeeCalculator(8)));
//        ParkingTicketTerminalStrategy ticket1 = new TicketDispenserTerminal(car1, new Output(new ConsoleOutput()));
//        ParkingAccessTicket car2 = new ParkingAccessTicket("Herbies", new FeeCalculator(new MinNoMaxFeeCalculator(8)));
//        ParkingTicketTerminalStrategy ticket2 = new TicketDispenserTerminal(car2, new Output(new ConsoleOutput()));
//    }
}
