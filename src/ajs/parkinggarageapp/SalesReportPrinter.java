package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class SalesReportPrinter implements ParkingTicketTerminalStrategy {

    //start new day
    //get ticket from exit terminal
    //send ticket data (hours and total fee) to sales report
    //send data to exit terminal to be printed
    private static final int CARS = 0;
    private SalesReport salesReport;
    private ParkingAccessTicket ticket;
    
    
    public final void startNewDay(OutputStrategy output, String garageName){
        this.salesReport = new SalesReport(output, garageName);
    }

    @Override
    public void ticketTransaction(ParkingAccessTicket ticket) {
        this.ticket = ticket;
        salesReport.newCar(ticket);
        salesReport.output();
    }
 
    
    public static void main(String[] args) {
        GarageNameStrategy name = new CustomGarageName("Herbies");
        OutputStrategy output = new ConsoleOutput();
        SalesReportPrinter sr = new SalesReportPrinter();
        sr.startNewDay(output, name.getName());        
        ParkingAccessTicket ticket1 = new ParkingAccessTicket(name.getName(), new MinNoMaxFeeCalculator(8));
        ParkingAccessTicket ticket2 = new ParkingAccessTicket(name.getName(), new MinNoMaxFeeCalculator(8));
        ParkingAccessTicket ticket3 = new ParkingAccessTicket(name.getName(), new MinNoMaxFeeCalculator(8));
        ParkingAccessTicket ticket4 = new ParkingAccessTicket(name.getName(), new MinNoMaxFeeCalculator(8));
       sr.ticketTransaction(ticket1);
       sr.ticketTransaction(ticket2);
       sr.ticketTransaction(ticket3);
       sr.ticketTransaction(ticket4);
       sr.startNewDay(output, name.getName());
    }
}
