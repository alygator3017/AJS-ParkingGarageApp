package ajs.parkinggarageapp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class starts a daily sales report.
 * Daily sales reports include daily hours, daily fee and total daily cars. 
 * @author ajSchmidt-Zimmel
 * @version 1.2
 */
public class NewSalesReport implements SalesReportDataStrategy {

    private static final int START_OF_DAY_CARS = 0;
    private final String garageName;
    private double totalDailyHours;
    private double totalDailyFee;
    private SalesReportData data;
    private int totalDailyCars = 0;

    
    //goes here every time you go back to the start screen
    
    /**
     * Constructor for NewSalesReport.
     * This constructor takes a garageName, which cannot be null or empty.
     * @param garageName The name of the garage.
     * @throws NullOrEmptyArgumentException Custom exception class.
     */
        
    public NewSalesReport(String garageName) throws NullOrEmptyArgumentException {
        if(garageName == null || garageName.isEmpty()){
            throw new NullOrEmptyArgumentException("garageName is null or empty in NewSalesReport constructor.");
        }
        this.totalDailyCars = START_OF_DAY_CARS;
        this.totalDailyFee = 0;
        this.totalDailyHours = 0;
        this.garageName = garageName;
    }

    /**
     * This method is for adding a new car to the daily sales report.
     * This takes hours which cannot be less than or equal to 0.
     * Also takes a fee which cannot be less that 1.50.
     * Calls the sales report data class constructor to add the sales to the salesReport data.
     * @param hours Hours the car was parked.
     * @param fee The total fee for the hours parked.
     * @throws NullOrEmptyArgumentException Custom exception class.
     */
    @Override
    public final void newCar(double hours, double fee) throws NullOrEmptyArgumentException {
        if (hours <= 0 || fee < 1.50) {
            throw new NullOrEmptyArgumentException("problems in new car");
        }
        this.data = new SalesReportData();
        try {
            addTotalsToSalesReport(hours, fee);
        } catch (NullOrEmptyArgumentException e) {
            System.out.println(e + " addTotalsToSalesReport exception null.");
        }
    }

    
    //MOVED THIS hERE AND ENDED HERE, CHECK SALES REPORT AND CHECK NEW DAY TO CLEAR TOTALS?


    
    private void addTotalsToSalesReport(double hours, double fee) throws NullOrEmptyArgumentException {
        if (hours <= 0 || fee < 1.50) {
            throw new NullOrEmptyArgumentException("totals are either null or out of range in addTotalsToSalesReport.");
        }
        this.totalDailyHours += hours;
        this.totalDailyFee += fee;
        totalDailyCars++;
     }

    /**
     * Sends the output data to the proper output class.
     * This method gets the sales report data for the sales report data class and
     * assigns it to a String to be returned.
     * @return The data string to be output.
     */
    @Override
    public final String output() {
        String dataString = null;
        try {
            dataString = data.getSalesReportData(garageName, totalDailyHours, totalDailyFee, totalDailyCars);
        } catch (NullOrEmptyArgumentException e) {
            System.out.println(e + " output failed in new sales report assigning to dataString null.");
        } catch (NumberOutOfRangeException ex) {
            System.out.println(ex + " output failed in new sales report assigning to dataString number out of range.");
        }
        return dataString;
    }

    /**
     * Returns the total daily sales.
     * This is useful for the file service.
     * @return totalDailyFee- the total fee for the garage for the day.
     */
    @Override
    public final double getTotalDailySales() {
        return totalDailyFee;
    }

    /**
     * Returns the total daily hours for the garage.
     * This is useful for the file service.
     * @return totalDailyHours- the total hours for the garage for the day.
     */
    @Override
    public final double getTotalDailyHours() {
        return totalDailyHours;
    }

    /**
     * Returns the total daily cars for the garage.
     * This is useful for the file service.
     * @return totalDailyCars- the total cars for the garage for the day.
     */
    @Override
    public final int getTotalDailyCars() {
        return totalDailyCars;
    }
}
