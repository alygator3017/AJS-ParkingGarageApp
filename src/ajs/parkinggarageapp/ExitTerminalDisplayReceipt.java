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
    private ParkingAccessTicket ticket;
    private final OutputStrategy output;

    public ExitTerminalDisplayReceipt(OutputStrategy output, ParkingAccessTicket ticket) {
        setTicket(ticket);
        this.output = output;
    }

    @Override
    public final ParkingAccessTicket getTicket() {
        return ticket;
    }

    private String getDisplayReceipt() {
        NumberFormat curr = NumberFormat.getCurrencyInstance();
        NumberFormat h = NumberFormat.getNumberInstance();
        final String newLine = "\n";
        StringBuilder receiptData = new StringBuilder();
        receiptData.append("Receipt").append(newLine);
        receiptData.append(DASHED).append(newLine);
        receiptData.append(newLine);
        receiptData.append(ticket.getTicket().getGarageName()).append(newLine);
        receiptData.append("Car ID: ").append(ticket.getTicket().getCarID()).append(newLine);
        receiptData.append("Total Hours Billed: ").append(h.format(ticket.getTicket().getFeeCalculatorStrategy().getHours())).append(newLine);
        receiptData.append("Total Fee: ").append(curr.format(ticket.getTicket().getFeeCalculatorStrategy().getTotalFee())).append(newLine);
        receiptData.append("Thank you for coming to ").append(ticket.getTicket().getGarageName()).append(newLine);
        String data = receiptData.toString();
        return data;
    }

    @Override
    public final void output() {
        output.outputData(getDisplayReceipt());
    }

    private void setTicket(ParkingAccessTicket ticket) {
        this.ticket = ticket;
    }

    public static void main(String[] args) {
        TerminalOutputTypeStrategy stuff = new ExitTerminalDisplayReceipt(new JOptionPaneOutput(), new ParkingAccessTicket("herbie", new MinNoMaxFeeCalculator(8)));
        stuff.output();
    }

}
