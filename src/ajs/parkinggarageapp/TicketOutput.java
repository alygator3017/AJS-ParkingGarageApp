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
    private ParkingAccessTicket ticket;
    private final OutputStrategy output;

    public TicketOutput(OutputStrategy ticketOutput, ParkingAccessTicket ticket) {
        setTicket(ticket);
        this.output = ticketOutput;
    }

    
    
    @Override
    public ParkingAccessTicket getTicket() {
        return ticket;
    }

    @Override
    public void output() {
        output.outputData(ticket.getTicket().ticketData());
    }

    private void setTicket(ParkingAccessTicket ticket) {
        this.ticket = ticket; 
        
    }
 
    public static void main(String[] args) {
        
        
    }

    
}
