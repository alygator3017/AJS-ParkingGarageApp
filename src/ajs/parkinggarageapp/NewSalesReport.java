package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class NewSalesReport implements SalesReportStrategy {

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
    public final void newCar(double hours, double fee) throws IllegalArgumentException {
        if (hours <= 0 || hours > 24 || fee < 1.50) {
            throw new IllegalArgumentException();
        }
        this.data = new SalesReportData();
        try {
            addTotalsToSalesReport(hours, fee);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    private void addTotalsToSalesReport(double hours, double fee) throws IllegalArgumentException {
        if (hours <= 0 || hours > 24 || fee < 1.50) {
            throw new IllegalArgumentException();
        }
        this.totalDailyHours += hours;
        this.totalDailyFee += fee;
        totalDailyCars++;
    }

    @Override
    public final String output() {
        String dataString = null;
        try {
            dataString = data.getSalesReportData(garageName, totalDailyHours, totalDailyFee, totalDailyCars);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        return dataString;
    }
}
