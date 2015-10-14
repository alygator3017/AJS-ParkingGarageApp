package ajs.parkinggarageapp;

import java.text.NumberFormat;

/**
 *
 * @author Alyson
 */
public class Receipt implements TerminalOutputTypeStrategy {
    private static final String DASHED = "======================================";
    //CREATE GETTER AND SETTER
    private ParkingAccessTicketData ticket;

    public Receipt(ParkingAccessTicketData ticket) {
        //USE GETTER AND SETTER AFTER CREATED
        setTicket(ticket);
        
    }
    
    private void setTicket(ParkingAccessTicketData ticket) {
        this.ticket = ticket;
    }
    
    @Override
    public final ParkingAccessTicketData getTicket(){
        return ticket;
    }
    
    @Override
    public final void output(){
        NumberFormat curr = NumberFormat.getCurrencyInstance();
        NumberFormat h = NumberFormat.getNumberInstance();
        final String newLine = "\n";
        StringBuilder receiptData = new StringBuilder();
        receiptData.append(DASHED).append(newLine);
        receiptData.append(ticket.getGarageName()).append(newLine);
        receiptData.append("Car ID: ").append(ticket.getCarID()).append(newLine);
        receiptData.append("Total Hours Billed: ").append(h.format(ticket.getFeeCalculatorStrategy().getHours())).append(newLine);
        receiptData.append("Total Fee: ").append(curr.format(ticket.getFeeCalculatorStrategy().getTotalFee())).append(newLine);
        String data = receiptData.toString();
        ticket.getOutput().outputData(data);
    }

}
