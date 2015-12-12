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
     * @throws ajs.parkinggarageapp.NullOrEmptyArgumentException Custom exception class.
     */
    public DispenserTerminal(OutputService ticketOutput) throws NullOrEmptyArgumentException {
        if(ticketOutput == null){
            throw new NullOrEmptyArgumentException("ticketOutput is null in DispenserTerminal constructor");
        }
        this.ticketOutput = ticketOutput;
    }

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
            throw new NullOrEmptyArgumentException("garageName, carID, sDate, or date is null or empty in ticketTransaction in DispenserTerminal");
        }
        TerminalOutputStrategy dataOutput = null;
        try {
            dataOutput = new TicketDataOutput(garageName, carID, sDate);
        } catch (NumberOutOfRangeException ex) {
            System.out.println(ex + " number out of range exception in ticketTransaction in DispenserTerminal when assigninging a new ticket data output to dataOuput variable.");
        }
        
        try {
            dataOutput.output(ticketOutput);
        } catch (NullOrEmptyArgumentException e) {
            ticketOutput.outputData(e + " null or empty when trying to send ticket output to output service in ticket transaction in dispenser terminal. ");
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
