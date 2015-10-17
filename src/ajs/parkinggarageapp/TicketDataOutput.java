/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajs.parkinggarageapp;

import ajs.parkinggarageapp.Output;
import ajs.parkinggarageapp.TerminalOutputTypeStrategy;

/**
 *
 * @author Alyson
 */
public class TicketDataOutput implements TerminalOutputTypeStrategy {
    private static final String DASHED = "======================================";
    private final String ticketData;

    public TicketDataOutput(String garageName, int carID, String Date) {
        this.ticketData = ticketData(garageName, carID, Date);
    }

    @Override
    public void output(Output output) {
        output.outputData(ticketData);
    }

    public final String ticketData(String garageName, int carID, String date){
        final String newLine = "\n";
        StringBuilder sbData = new StringBuilder(DASHED);
        sbData.append(garageName).append("\n").append(newLine);
        sbData.append("Car ID: ").append(carID).append(newLine);
        sbData.append("Entered garage on: ").append(date).append(newLine);
        sbData.append(DASHED).append(newLine);
        String data = sbData.toString();
        return data;
    }

    
}
