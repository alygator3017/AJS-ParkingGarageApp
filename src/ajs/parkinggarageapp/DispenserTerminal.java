package ajs.parkinggarageapp;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Starting point for parking ticket transactions.
 * Starts the ticket transaction, creates a new parking access ticket, and prints
 * it out to the designated output source defined in the constructor. 
 * 
 * @author ajSchmidt-Zimmel
 * @version 1.2
 */
public class DispenserTerminal implements ParkingTerminalStrategy {

    private final OutputService ticketOutput;
    
    /**
     * Constructor for subclasses to call. 
     * @param ticketOutput Output in which the ticket will print to
     */
    public DispenserTerminal(OutputService ticketOutput) {
        this.ticketOutput = ticketOutput;
    }
//DON'T THINK I NEED THIS, IF I DON'T THEN DELETE IT BEFORE TURN IN
//    public final void newTicket(String garageName, int carID, double hours, double fee, String date) throws NullOrEmptyArgumentException {
//        if (garageName == null || garageName.isEmpty() || carID <= 0 || hours <= 0 || hours > 24 || fee < 1.50 || date == null || date.isEmpty()) {
//            throw new NullOrEmptyArgumentException();
//        }
//        ticketTransaction(garageName, carID, hours, fee, date);
//
//    }

    /**
     * Creates a new ticket.
     * Ticket is created and then sent for assigned output. garageName, carID, hours
     * fee, and date cannot be null or empty. carID has to be above 0 and hours 
     * between 0 and 24. The fee has to be greater than 1.50. Otherwise a 
     * custom exception will be thrown. 
     * @param garageName name of the garage
     * @param carID id of the car
     * @param date
     * @param sDate the starting date and time of the starting transaction
     * @throws NullOrEmptyArgumentException
     */
    @Override
    public final void ticketTransaction(String garageName, int carID, String sDate, LocalDateTime date) throws NullOrEmptyArgumentException {
        if (garageName == null || garageName.isEmpty() || carID <= 0 || sDate == null || sDate.isEmpty() || date == null) {
            throw new NullOrEmptyArgumentException();
        }
        TerminalOutputStrategy dataOutput = new TicketDataOutput(garageName, carID, sDate);
        
        try {
            dataOutput.output(ticketOutput);
        } catch (NullOrEmptyArgumentException e) {
            ticketOutput.outputData(e);
        }
    }
   

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.ticketOutput);
        return hash;
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DispenserTerminal other = (DispenserTerminal) obj;
        if (!Objects.equals(this.ticketOutput, other.ticketOutput)) {
            return false;
        }
        return true;
    }

}
