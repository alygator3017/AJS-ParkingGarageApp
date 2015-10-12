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
public interface ParkingTicketTerminalStrategy {

    public abstract void ticketTransaction(ParkingAccessTicket ticket);
    public abstract void outputData();
    
}
