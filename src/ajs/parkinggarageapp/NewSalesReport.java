package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class NewSalesReport implements SalesReportStrategy{

    //get new ticket hours and fee
    //add to totalDailyHours and totalDailyFee property
    //add how many cars (car id?)
    //put data into sales report data string
    //output data string
    private static final int START_OF_DAY_CARS = 0;
    private final String garageName;
    private double totalDailyHours;
    private double totalDailyFee;
    private SalesReportData data;
    private int totalDailyCars = 0;

    public NewSalesReport(String garageName) {
        this.totalDailyCars = START_OF_DAY_CARS;
        this.totalDailyFee = 0;
        this.totalDailyHours = 0;
        this.garageName = garageName;
    }
    
    @Override
    public void newCar(double hours, double fee){
        this.data = new SalesReportData();
        addTotalsToSalesReport(hours, fee);
    }

    private void addTotalsToSalesReport(double hours, double fee) {
        this.totalDailyHours += hours;
        this.totalDailyFee += fee;
        totalDailyCars++;
    }

    @Override
    public String output() {
        return data.getSalesReportData(garageName, totalDailyHours, totalDailyFee, totalDailyCars);
    }
}

//    public static void main(String[] args) {
//        String garageName = "herbies";
//        OutputStrategy output = new ConsoleOutput();
//        ParkingAccessTicket ticket1 = new ParkingAccessTicket(garageName, new FeeCalculator("Min No Max", 8));
//        ParkingAccessTicket ticket2 = new ParkingAccessTicket(garageName, new FeeCalculator("Min No Max", 8));
//        ParkingAccessTicket ticket3 = new ParkingAccessTicket(garageName, new FeeCalculator("Min No Max", 8));
//        ParkingAccessTicket ticket4 = new ParkingAccessTicket(garageName, new FeeCalculator("Min No Max", 8));
//        NewSalesReport report = new NewSalesReport(output, ticket1.getGarageName());
//        report.newCar(ticket1);
//        report.output();
//        report.newCar(ticket2);
//        report.output();
//        report.newCar(ticket3);
//        report.output();
//        report.newCar(ticket4);
//        report.output();
//    }