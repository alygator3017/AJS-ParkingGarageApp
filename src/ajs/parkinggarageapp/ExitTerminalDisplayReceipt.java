/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajs.parkinggarageapp;

import java.text.NumberFormat;

/**
 *
 * @author Alyson
 */
public class ExitTerminalDisplayReceipt implements TerminalOutputTypeStrategy {

    private static final String DASHED = "======================================";
    private final double fee;
    private final double hours;
    private final int carID;
    private final String garageName;

    public ExitTerminalDisplayReceipt(String garageName, int carID, double hours, double fee) {
        this.garageName = garageName;
        this.carID = carID;
        this.hours = hours;
        this.fee = fee;
    }

    private String getDisplayReceipt() {
        NumberFormat curr = NumberFormat.getCurrencyInstance();
        NumberFormat h = NumberFormat.getNumberInstance();
        final String newLine = "\n";
        StringBuilder receiptData = new StringBuilder();
        receiptData.append("Receipt").append(newLine);
        receiptData.append(DASHED).append(newLine);
        receiptData.append(newLine);
        receiptData.append(garageName).append(newLine);
        receiptData.append("Car ID: ").append(carID).append(newLine);
        receiptData.append("Total Hours Billed: ").append(hours).append(newLine);
        receiptData.append("Total Fee: ").append(curr.format(fee)).append(newLine);
        receiptData.append("Thank you for coming to ").append(garageName).append(newLine);
        String data = receiptData.toString();
        return data;
    }
    
    @Override
    public void output(Output output) {
        output.outputData(getDisplayReceipt());
    }

}
