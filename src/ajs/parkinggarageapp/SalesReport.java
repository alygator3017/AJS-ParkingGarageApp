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
    private final OutputStrategy output;

    public SalesReport(OutputStrategy output, String garageName) {
        this.totalDailyCars = START_OF_DAY_CARS;
        this.totalDailyFee = 0;
        this.totalDailyHours = 0;
        this.garageName = garageName;
        this.output = output;
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
        output.outputData(data.getSalesReportData(garageName, totalDailyHours, totalDailyFee, totalDailyCars));
    }

     
    public static void main(String[] args) {
        GarageNameStrategy name = new GarageName("Herbies");
        OutputStrategy output = new ConsoleOutput();
        ParkingAccessTicket ticket1 = new ParkingAccessTicket(name.getName(), new MinNoMaxFeeCalculator(8));
        ParkingAccessTicket ticket2 = new ParkingAccessTicket(name.getName(), new MinNoMaxFeeCalculator(8));
        ParkingAccessTicket ticket3 = new ParkingAccessTicket(name.getName(), new MinNoMaxFeeCalculator(8));
        ParkingAccessTicket ticket4 = new ParkingAccessTicket(name.getName(), new MinNoMaxFeeCalculator(8));
        SalesReport report = new SalesReport(output, name.getName());
        report.newCar(ticket1);
        report.output();
        report.newCar(ticket2);
        report.output();
        report.newCar(ticket3);
        report.output();
        report.newCar(ticket4);
        report.output();
    }
    
}
