package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class SaleReportPrinter implements ParkingTicketTerminalStrategy {

    //start new day
    //get ticket from exit terminal
    //send ticket data (hours and total fee) to sales report
    //send data to exit terminal to be printed
    private static final int CARS = 0;
    private SalesReport newDailySalesReport;

    public SaleReportPrinter(String garageName) { 
        startNewDay(garageName);
    }
    
    
    public final void startNewDay(String garageName){
        this.newDailySalesReport = new SalesReport(garageName);
    }

    @Override
    public void ticketTransaction(ParkingAccessTicket ticket) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void startDay(){
        
    }
    
}
