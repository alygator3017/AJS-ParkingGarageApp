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

    private ParkingAccessTicket ticket;
    
    private final OutputStrategy display = new JOptionPaneOutput();

    public ExitTerminalDisplayReceipt(ParkingAccessTicket ticket) {
        setTicket(ticket);
    }
    
    
    
    @Override
    public final ParkingAccessTicket getTicket() {
        return ticket;
    }

    @Override
    public final void output() {
        NumberFormat curr = NumberFormat.getCurrencyInstance();
        NumberFormat h = NumberFormat.getNumberInstance();
        final String newLine = "\n";
        StringBuilder receiptData = new StringBuilder();
        receiptData.append("Terminal Display").append(newLine);
        receiptData.append(newLine);
        receiptData.append(ticket.getGarageName()).append(newLine);
        receiptData.append("Car ID: ").append(ticket.getCarID()).append(newLine);
        receiptData.append("Total Hours Billed: ").append(h.format(ticket.getFeeCalculatorStrategy().getHours())).append(newLine);
        receiptData.append("Total Fee Due: ").append(curr.format(ticket.getFeeCalculatorStrategy().totalFee())).append(newLine);
        String data = receiptData.toString();
        display.outputData(data);
    }
    
    private void setTicket(ParkingAccessTicket ticket) {
        this.ticket = ticket;
    }
    
}
