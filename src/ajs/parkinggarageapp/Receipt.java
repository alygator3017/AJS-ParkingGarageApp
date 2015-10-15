package ajs.parkinggarageapp;

import java.text.NumberFormat;

/**
 *
 * @author Alyson
 */
public class Receipt implements TerminalOutputTypeStrategy {
    private static final String DASHED = "======================================";
    //CREATE GETTER AND SETTER
    private ParkingAccessTicket ticket;
    private final OutputStrategy output;

    public Receipt(OutputStrategy output, ParkingAccessTicket ticket) {
        //USE GETTER AND SETTER AFTER CREATED
        setTicket(ticket);
        this.output = output;
        
    }
    
    private void setTicket(ParkingAccessTicket ticket) {
        this.ticket = ticket;
    }
    private String getReceiptData(){
        NumberFormat curr = NumberFormat.getCurrencyInstance();
        NumberFormat h = NumberFormat.getNumberInstance();
        final String newLine = "\n";
        StringBuilder receiptData = new StringBuilder();
        receiptData.append(DASHED).append(newLine);
        receiptData.append(ticket.getTicket().getGarageName()).append(newLine);
        receiptData.append("Car ID: ").append(ticket.getTicket().getCarID()).append(newLine);
        receiptData.append("Total Hours Billed: ").append(h.format(ticket.getTicket().getFeeCalculatorStrategy().getHours())).append(newLine);
        receiptData.append("Total Fee: ").append(curr.format(ticket.getTicket().getFeeCalculatorStrategy().getTotalFee())).append(newLine);
        String data = receiptData.toString();
        return data;
    }
    @Override
    public final ParkingAccessTicket getTicket(){
        return ticket;
    }
    
    @Override
    public final void output(){
        output.outputData(getReceiptData());
    }

}
