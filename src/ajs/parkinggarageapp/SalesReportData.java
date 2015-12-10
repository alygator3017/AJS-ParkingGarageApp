package ajs.parkinggarageapp;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;


/**
 *
 * @author ajSchmidt-Zimmel
 */
public class SalesReportData{
    private static final String DASHED = "======================================";
    private Date currentDateTime;
    private final SimpleDateFormat date = new SimpleDateFormat("EEE, MMM d, yyyy");

    private String salesReportData(String garageName, double hours, double fee, int cars) throws NullOrEmptyArgumentException{
        if(garageName == null || garageName.isEmpty() || hours <= 0 || hours > 24 || fee < 1.50 || cars <= 0){
            throw new NullOrEmptyArgumentException();
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
    
    public final String getSalesReportData(String garageName, double hours, double fee, int cars) throws NullOrEmptyArgumentException{
        if(garageName == null || garageName.isEmpty() || hours <= 0 || hours > 24 || fee < 1.50 || cars <= 0){
            throw new NullOrEmptyArgumentException();
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
