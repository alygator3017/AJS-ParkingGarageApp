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
public interface TerminalOutputTypeStrategy {

    public abstract ParkingAccessTicketData getTicket();

    public abstract void output();
    
}
