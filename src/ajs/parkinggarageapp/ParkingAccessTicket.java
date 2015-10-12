/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajs.parkinggarageapp;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Alyson
 */
public class ParkingAccessTicket {
    
    private Date currentDateTime;
    private final SimpleDateFormat date = new SimpleDateFormat("EEE, MMM d, yyyy hh:mm aaa");
    private String ticketDate;
    private OutputStrategy output;
    private FeeCalculatorStrategy fee;
    private static int carIDCounter = 0;
    private int carID;
    //faking hour data for the moment
    private double hours;
    private String garageName;

    /**
     * this would be the constructor with non-fake data
     * @param output
     */
//    public ParkingAccessTicket(OutputStrategy output){ 
//       newTicket();
//    }

    /**
     * needed in order to fake data
     * @param hours 
     * @param output 
     * @param garageName 
     * @param feeCalculator 
     */
//    public ParkingAccessTicket(double hours, OutputStrategy output, String garageName) {
//        setHours(hours);
//        newTicket();
//        //fix later
//        setGarageName(garageName);
//    }
    public ParkingAccessTicket(OutputStrategy output, GarageNameStrategy garageName, FeeCalculatorStrategy feeCalculator) {
        setHours(feeCalculator.getHours());
        newTicket();
        setOutput(output);
        //fix later
        setGarageName(garageName.getName());
        setFeeCalculatorStrategy(feeCalculator);
    }
    
    public final void newTicket(){
        carIDCounter++;
        currentDateTime = new Date();
        setTicketDate(currentDateTime);
        carID = carIDCounter;
    }

    public final void printTicket(){
        final String newLine = "\n";
        StringBuilder ticketData = new StringBuilder(getGarageName() + "\n");
        ticketData.append("Car ID: ").append(getCarID()).append(newLine);
        ticketData.append(getTicketDate()).append(newLine);
        String data = ticketData.toString();
        output.outputData(data);
        
    }
    /**
     * wouldn't need for non-fake data
     * @return 
     */
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

    public final String getTicketDate(){
        return ticketDate;
    }
    
    private void setTicketDate(Date currentDatetime) {
        this.ticketDate = date.format(currentDateTime);
    }

    
    public final OutputStrategy getOutput() {
        return output;
    }

    public final void setOutput(OutputStrategy output) {
        this.output = output;
    }

    public final int getCarID() {
        return carID;
    }

    //FIX LATER
    public String getGarageName() {
        return garageName;
    }

    private void setGarageName(String garageName) {
        this.garageName = garageName;
    }

    private void setFeeCalculatorStrategy(FeeCalculatorStrategy feeCalculator) {
        fee = feeCalculator;
    }
    
    public FeeCalculatorStrategy getFeeCalculatorStrategy(){
        return fee;
    }
}
