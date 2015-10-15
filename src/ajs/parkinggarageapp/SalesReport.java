package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class SalesReport implements TerminalOutputTypeStrategy{

    //get new ticket hours and fee
    //add to totalDailyHours and totalDailyFee property
    //add how many cars (car id?)
    //put data into sales report data string
    //output data string
    private static final int START_OF_DAY_CARS = 0;
    private final String garageName;
    private double totalDailyHours;
    private double totalDailyFee;
    private int totalDailyCars = 0;
    private ParkingAccessTicket ticket;

    public SalesReport(String garageName) {
        this.totalDailyCars = START_OF_DAY_CARS;
        this.totalDailyFee = 0;
        this.totalDailyHours = 0;
        this.garageName = garageName;
    }
    
    public void newCar(ParkingAccessTicket ticket){
        this.ticket = ticket;
        addTotalsToSalesReport(ticket.getTicket().getHours(), ticket.getTicket().getFeeCalculatorStrategy().getTotalFee());
    }

    private void addTotalsToSalesReport(double hours, double fee) {
        this.totalDailyHours += hours;
        this.totalDailyFee += fee;
        totalDailyCars++;
    }
    @Override
    public ParkingAccessTicket getTicket() {
        return ticket;
    }

    @Override
    public void output() {
        SalesReportData data = new SalesReportData();
        data.getSalesReportData(garageName, totalDailyHours, totalDailyFee, totalDailyCars);
        
    }

     
    
    
}
