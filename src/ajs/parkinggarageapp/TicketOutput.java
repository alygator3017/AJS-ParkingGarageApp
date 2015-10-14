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
public class TicketOutput implements TerminalOutputTypeStrategy {
    private ParkingAccessTicketData ticket;
    private final OutputStrategy output;

    public TicketOutput(OutputStrategy output, ParkingAccessTicketData ticket) {
        setTicket(ticket);
        this.output = output;
    }

    
    
    @Override
    public ParkingAccessTicketData getTicket() {
        return ticket;
    }

    @Override
    public void output() {
        output.outputData(ticket.ticketData());
    }

    private void setTicket(ParkingAccessTicketData ticket) {
        this.ticket = ticket; 
        
    }
 
    public static void main(String[] args) {
        
    }
}
