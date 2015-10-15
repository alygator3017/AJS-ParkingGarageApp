package ajs.parkinggarageapp;

import java.text.NumberFormat;

/**
 *
 * @author Alyson
 */
public class SalesReportData{
    private static final String DASHED = "======================================";

    private String salesReportData(String garageName, double hours, double fee, int cars){
        NumberFormat curr = NumberFormat.getCurrencyInstance();
        NumberFormat h = NumberFormat.getNumberInstance();
        final String newLine = "\n";
        StringBuilder receiptData = new StringBuilder();
        receiptData.append(garageName).append(newLine);
        receiptData.append(DASHED).append(newLine);
        receiptData.append("Daily Garage Totals").append(newLine);
        receiptData.append(DASHED).append(newLine);
        receiptData.append("TotalCars: ").append(cars).append(newLine);
        receiptData.append("Total Hours Billed: ").append(h.format(hours)).append(newLine);
        receiptData.append("Collected: ").append(curr.format(fee)).append(newLine);
        String data = receiptData.toString();
        return data;
    }
    
    public String getSalesReportData(String garageName, double hours, double fee, int cars){
        return salesReportData(garageName, hours, fee, cars);
    }
    
    public static void main(String[] args) {
        SalesReportData data = new SalesReportData();
        System.out.println(data.getSalesReportData("Herbies", 32.56, 92.34532, 11));
        
    }
    
}
