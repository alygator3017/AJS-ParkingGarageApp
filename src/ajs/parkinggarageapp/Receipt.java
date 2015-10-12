package ajs.parkinggarageapp;

import java.text.NumberFormat;

/**
 *
 * @author Alyson
 */
public class Receipt {
    private static final String DASHED = "======================================";
    //CREATE GETTER AND SETTER
    private ParkingAccessTicket ticket;
    private FeeCalculatorStrategy fee;

    public Receipt(FeeCalculatorStrategy fee, ParkingAccessTicket ticket) {
        //USE GETTER AND SETTER AFTER CREATED
        setTicket(ticket);
        setFee(fee);
        
    }
    
    public final FeeCalculatorStrategy getFee() {
        return fee;
    }

    private void setFee(FeeCalculatorStrategy fee) {
        this.fee = fee;
    }
    
    private void setTicket(ParkingAccessTicket ticket) {
        this.ticket = ticket;
    }
    
    public final ParkingAccessTicket getTicket(){
        return ticket;
    }
    
    public final void output(){
        NumberFormat curr = NumberFormat.getCurrencyInstance();
        NumberFormat h = NumberFormat.getNumberInstance();
        final String newLine = "\n";
        StringBuilder receiptData = new StringBuilder();
        receiptData.append(DASHED).append(newLine);
        receiptData.append(ticket.getGarageName()).append(newLine);
        receiptData.append("Car ID: ").append(ticket.getCarID()).append(newLine);
        receiptData.append("Total Hours Billed: ").append(h.format(fee.getHours())).append(newLine);
        receiptData.append("Total Fee: ").append(curr.format(fee.totalFee())).append(newLine);
        String data = receiptData.toString();
        ticket.getOutput().outputData(data);
    }
    
    
//    public static void main(String[] args) {
//        GarageNameStrategy garage = new BestValueParkingGarage();
//        OutputStrategy output = new ConsoleOutput();
//        ParkingAccessTicket t1 = new ParkingAccessTicket(8.55, output, garage);
//        Receipt receipt = new Receipt(new MinMaxFeeCalculator(t1.getHours()), t1);
//        receipt.output();
//        
//    }

}
