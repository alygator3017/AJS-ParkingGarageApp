package ajs.parkinggarageapp;

import java.text.NumberFormat;

/**
 *
 * @author Alyson
 */
public class SalesReportData{


    private String salesReportData(String garageName, double hours, double fee, int cars){
        NumberFormat curr = NumberFormat.getCurrencyInstance();
        NumberFormat h = NumberFormat.getNumberInstance();
        final String newLine = "\n";
        StringBuilder receiptData = new StringBuilder();
        receiptData.append(garageName).append(newLine);
        receiptData.append("TotalCars: ").append(cars).append(newLine);
        receiptData.append("Total Hours Billed: ").append(h.format(hours)).append(newLine);
        receiptData.append("Collected: ").append(curr.format(fee)).append(newLine);
        String data = receiptData.toString();
        return data;
    }
    
    public String getSalesReportData(String garageName, double hours, double fee, int cars){
        return salesReportData(garageName, hours, fee, cars);
    }
    
    
    
}
