/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public interface ParkingAccessTicketDataStrategy{

    int getCarID();

    FeeCalculator getFeeCalculator();

    //FIX LATER
    String getGarageName();

    /**
     * wouldn't need for non-fake data
     * @return
     */
    double getHours();

    String getTicketDate();

    void newTicket();
    
}
