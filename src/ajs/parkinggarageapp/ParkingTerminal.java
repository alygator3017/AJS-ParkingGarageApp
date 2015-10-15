package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class ParkingTerminal {
    
    ParkingTicketTerminalStrategy exit;
    private final SalesReportPrinter salesReport;
    private final OutputStrategy printerOutput;
    private final String garageName;
    private final TicketDispenserTerminal enter;

    public ParkingTerminal(OutputStrategy ticketOutput, OutputStrategy receiptOutput, OutputStrategy displayOutput, OutputStrategy printerOutput, GarageNameStrategy garageName ) {
         this.exit = new ExitTerminalTransaction(receiptOutput, displayOutput);
         this.enter = new TicketDispenserTerminal(ticketOutput);
         salesReport = new SalesReportPrinter();
         this.printerOutput = printerOutput;
         this.garageName = garageName.getName();
         startNewDay();
    }
    
    public final void startNewDay(){
        salesReport.startNewDay(printerOutput, garageName);
        
    }
    
    public final void newParkingTicket(ParkingAccessTicket ticket){
        enter.ticketTransaction(ticket);
    }
    
    public final void exitParkingGarage(ParkingAccessTicket ticket){
        exit.ticketTransaction(ticket);
        salesReport.ticketTransaction(ticket);
    }
    
    
    
}
