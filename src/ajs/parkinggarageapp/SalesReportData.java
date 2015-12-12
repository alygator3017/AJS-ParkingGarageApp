package ajs.parkinggarageapp;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;


/**
 * Sales report compiled data to be passed to output service. 
 * Combines all information into a readable sales report and then is passed for output.
 * @author ajSchmidt-Zimmel
 * @version 1.2
 */
public class SalesReportData{
    private static final String DASHED = "======================================";
    private Date currentDateTime;
    private final SimpleDateFormat date = new SimpleDateFormat("EEE, MMM d, yyyy");

    private String salesReportData(String garageName, double hours, double fee, int cars) throws NullOrEmptyArgumentException, NumberOutOfRangeException{
        if(garageName == null || garageName.isEmpty()){
            throw new NullOrEmptyArgumentException("garagename is empty in salesReportData method in SalesReportData class. ");
        }else if(hours <=0){
            throw new NumberOutOfRangeException("hours is out of range in salesReportdata method in SalesReportData class.");
        }else if(fee < 1.50){
            throw new NumberOutOfRangeException("fee is out of range in salesReportData method in SalesReportData class.");
        }else if (cars<=0){
            throw new NumberOutOfRangeException("cars if less than or equal to 0 in salesReportData method in SalesReportData class");
        }
        currentDateTime = new Date();
        NumberFormat curr = NumberFormat.getCurrencyInstance();
        NumberFormat h = NumberFormat.getNumberInstance();
        final String newLine = "\n";
        StringBuilder receiptData = new StringBuilder();
        receiptData.append(DASHED).append(newLine);
        receiptData.append(garageName).append(newLine);
        receiptData.append(date.format(currentDateTime)).append(newLine);
        receiptData.append("Daily Garage Totals").append(newLine);
        receiptData.append("TotalCars: ").append(cars).append(newLine);
        receiptData.append("Total Hours Billed: ").append(h.format(hours)).append(newLine);
        receiptData.append("Collected: ").append(curr.format(fee)).append(newLine);
        receiptData.append(DASHED).append(newLine);
        String data = receiptData.toString();
        return data;
    }
    
    /**
     * 
     * Takes the data to be turned into a sales report, creates the report
     * and returns the sales report data in a String to be printed. 
     * garageName cannot be empty or null, hours cannot be out of the range of 1 and
     * 24, fee cannot be less than 1.50 and cars cannot be less than or equal to 0.
     * @param garageName Name of the garage.
     * @param hours Total hours cars were parked.
     * @param fee Total fees cars were parked.
     * @param cars Total number of cars parked that day.
     * @return The sales report data.
     * @throws NullOrEmptyArgumentException Custom exception class
     * @throws ajs.parkinggarageapp.NumberOutOfRangeException Custom exception class.
     */
    public final String getSalesReportData(String garageName, double hours, double fee, int cars) throws NullOrEmptyArgumentException, NumberOutOfRangeException{
        if(garageName == null || garageName.isEmpty()){
            throw new NullOrEmptyArgumentException("garageName cannot be null or empty in getSalesReportData method in SalesReportData");
        }else if(hours <= 0 || hours > 24){
            throw new NumberOutOfRangeException("hours cannot be less than or equal to 0 or greater than 24 in getSalesReportData in SalesReportData " + hours);
        }else if (fee < 1.50){
            throw new NumberOutOfRangeException("fees cannot be less than 1.50 in getSalesReportData in SalesReportData " + fee);
        }else if (cars <= 0){
            throw new NumberOutOfRangeException("cars cannot be less than or equal to 0 in getSalesReportData in SalesReportData " + cars);
        }
        String salesReportData = null;
        try{
            salesReportData = salesReportData(garageName, hours, fee, cars);
        }catch (NullOrEmptyArgumentException e){
            System.out.println(e);
        }
        return salesReportData;
    }

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.currentDateTime);
        hash = 37 * hash + Objects.hashCode(this.date);
        return hash;
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SalesReportData other = (SalesReportData) obj;
        if (!Objects.equals(this.currentDateTime, other.currentDateTime)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }
    
}
