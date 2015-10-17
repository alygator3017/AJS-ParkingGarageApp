package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class ParkingTerminal {
    
    private ParkingTicketTerminalStrategy exit;
    private final Output printerOutput;
    private final String garageName;
    private final ParkingTicketTerminalStrategy enter;
    private final Output receiptOutput;
    private final Output displayOutput;

    public ParkingTerminal(Output ticketOutput, Output receiptOutput, Output displayOutput, Output printerOutput, GarageName garageName ) {
         this.exit = new ExitTerminalTransaction(displayOutput, receiptOutput, printerOutput, garageName.getName());
         this.enter = new TicketDispenserTerminal(ticketOutput);
         this.printerOutput = printerOutput;
         this.displayOutput = displayOutput;
         this.receiptOutput = receiptOutput;
         this.garageName = garageName.getName();
    }
    
    public final void startNewDay(){
        this.exit = new ExitTerminalTransaction(displayOutput, receiptOutput, printerOutput, garageName);
    }
    public final void newParkingTicket(ParkingAccessTicket ticket){
        if(ticket.getCarID() == 0){
            throw new IllegalArgumentException();
        }
        enter.ticketTransaction(ticket.getGarageName(), ticket.getCarID(), ticket.getHours(), ticket.getFee(), ticket.getDateOfAccess());
    }
    
    public final void exitParkingGarage(ParkingAccessTicket ticket){
        exit.ticketTransaction(ticket.getGarageName(), ticket.getCarID(), ticket.getHours(), ticket.getFee(), ticket.getDateOfAccess());
    }
    
    public static void main(String[] args) {
        Output console = new Output(new ConsoleOutput());
        Output jOp = new Output(new JOptionPaneOutput());
        GarageName garageName = new GarageName("Herbies");
        
        ParkingAccessTicket car1 = new ParkingAccessTicket(garageName.getName(), new FeeCalculator(new MinNoMaxFeeCalculator(8)));
        ParkingAccessTicket car2 = new ParkingAccessTicket(garageName.getName(), new FeeCalculator(new MinNoMaxFeeCalculator(8)));
        ParkingAccessTicket car3 = new ParkingAccessTicket(garageName.getName(), new FeeCalculator(new MinNoMaxFeeCalculator(8)));
        ParkingAccessTicket car4 = new ParkingAccessTicket(garageName.getName(), new FeeCalculator(new MinNoMaxFeeCalculator(8)));
        
        ParkingTerminal pt = new ParkingTerminal(console, console, jOp, console, garageName);
        pt.newParkingTicket(car1);
        pt.newParkingTicket(car2);
        pt.exitParkingGarage(car2);
        pt.newParkingTicket(car3);
        pt.exitParkingGarage(car1);
        pt.newParkingTicket(car4);
        pt.exitParkingGarage(car3);
        pt.exitParkingGarage(car4);
        
        pt.startNewDay();
        
        pt.newParkingTicket(car1);
        pt.newParkingTicket(car2);
        pt.exitParkingGarage(car1);
        pt.exitParkingGarage(car2);
        
    }
    
}
