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
class ExitTerminalDisplayTicketInfoAndFeeTotal implements TerminalOutputTypeStrategy {

    private static final String DASHED = "======================================";
    private final ParkingAccessTicket ticket;
    private final OutputStrategy displayOutput;
    
    public ExitTerminalDisplayTicketInfoAndFeeTotal(OutputStrategy output, ParkingAccessTicket ticket) {
        this.ticket = ticket;
        this.displayOutput = output;
    }

    @Override
    public ParkingAccessTicket getTicket() {
        return ticket;
    }

    private String getDisplay(){
        NumberFormat curr = NumberFormat.getCurrencyInstance();
        NumberFormat h = NumberFormat.getNumberInstance();
        final String newLine = "\n";
        StringBuilder receiptData = new StringBuilder();
        receiptData.append(ticket.getTicket().getGarageName()).append(newLine);
        receiptData.append("Ticket information").append(newLine);
        receiptData.append(DASHED).append(newLine);
        receiptData.append("Car ID: ").append(ticket.getTicket().getCarID()).append(newLine);
        receiptData.append("Total Hours Billed: ").append(h.format(ticket.getTicket().getFeeCalculatorStrategy().getHours())).append(newLine);
        receiptData.append("Total Fee Due: ").append(curr.format(ticket.getTicket().getFeeCalculatorStrategy().getTotalFee())).append(newLine);
        String data = receiptData.toString();
        return data;
    }
    @Override
    public void output() {
        displayOutput.outputData(getDisplay());
    }
    public static void main(String[] args) {
        TerminalOutputTypeStrategy stuff = new ExitTerminalDisplayTicketInfoAndFeeTotal(new JOptionPaneOutput(), new ParkingAccessTicket("Herbies", new MinNoMaxFeeCalculator(8)));
        
        stuff.output();
    }
}
