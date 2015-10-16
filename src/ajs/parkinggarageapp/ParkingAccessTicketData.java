package ajs.parkinggarageapp;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Alyson
 */
public class ParkingAccessTicketData implements ParkingAccessTicketDataStrategy {
    
    private Date currentDateTime;
    private final SimpleDateFormat date = new SimpleDateFormat("EEE, MMM d, yyyy hh:mm aaa");
    private String ticketDate;
    private FeeCalculator fee;
    private static int carIDCounter = 0;
    private int carID;
    //faking hour data for the moment
    private double hours;
    private String garageName;

    /**
     * this would be the constructor with non-fake data
     * @param output
     */
//    public ParkingAccessTicketData(OutputStrategy output){ 
//       newTicket();
//    }

    /**
     * needed in order to fake data
     * @param garageName 
     * @param feeCalculator 
     */
//    public ParkingAccessTicketData(double hours, OutputStrategy output, String garageName) {
//        setHours(hours);
//        newTicket();
//        //fix later
//        setGarageName(garageName);
//    }
    public ParkingAccessTicketData(GarageNameStrategy garageName, FeeCalculator feeCalculator) {
        setHours(feeCalculator.getHours());
        newTicket();
        //fix later
        setGarageName(garageName.getName());
        setFeeCalculator(feeCalculator);
    }
    
    @Override
    public final void newTicket(){
        carIDCounter++;
        currentDateTime = new Date();
        setTicketDate(currentDateTime);
        carID = carIDCounter;
    }

    @Override
    public final String ticketData(){
        final String newLine = "\n";
        StringBuilder ticketData = new StringBuilder(getGarageName() + "\n");
        ticketData.append("Car ID: ").append(getCarID()).append(newLine);
        ticketData.append("Entered garage on: ").append(getTicketDate()).append(newLine);
        String data = ticketData.toString();
        return data;
    }
    
    /**
     * wouldn't need for non-fake data
     * @return 
     */
    @Override
    public final double getHours() {
        return hours;
    }

    /**
     * wouldn't need for non-fake data
     * @param hours 
     */
    private void setHours(double hours) {
        this.hours = hours;
    }

    @Override
    public final String getTicketDate(){
        return ticketDate;
    }
    
    private void setTicketDate(Date currentDatetime) {
        this.ticketDate = date.format(currentDateTime);
    }

    @Override
    public final int getCarID() {
        return carID;
    }

    //FIX LATER
    @Override
    public String getGarageName() {
        return garageName;
    }

    private void setGarageName(String garageName) {
        this.garageName = garageName;
    }

    private void setFeeCalculator(FeeCalculator feeCalculator) {
        fee = feeCalculator;
    }
    
    @Override
    public FeeCalculator getFeeCalculator(){
        return fee;
    }
    public static void main(String[] args) {
        ParkingAccessTicketData ticket1 = new ParkingAccessTicketData(new CustomGarageName("herbie parking"), new FeeCalculator("Min No MAX", 8));
        System.out.println(ticket1.ticketData());
    }

    
}
