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
         this.exit = new ExitTerminal(displayOutput, receiptOutput, printerOutput, garageName.getName());
         this.enter = new TicketDispenserTerminal(ticketOutput);
         this.printerOutput = printerOutput;
         this.displayOutput = displayOutput;
         this.receiptOutput = receiptOutput;
         this.garageName = garageName.getName();
    }
    
    public final void startNewDay(){
        this.exit = new ExitTerminal(displayOutput, receiptOutput, printerOutput, garageName);
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
    
    
}
