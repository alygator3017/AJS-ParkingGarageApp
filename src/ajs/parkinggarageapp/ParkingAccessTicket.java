package ajs.parkinggarageapp;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Parking access ticket class for getting information in the parking access ticket data strategy classes.
 * Able to collect the ticket's date and time as well as the car ID and garage name.
 * @author ajSchmidt-Zimmel
 * @version 1.2
 */
public class ParkingAccessTicket {

    private final ParkingAccessTicketDataStrategy newTicket;
    private final String garage;
//    private final OutputStrategy output;

    /**
     * Constructor to create a new ticket.
     * Creates a new ticket using liskov's substitution principle.
     * @param garageName data on the parking garage.
     * @throws ajs.parkinggarageapp.NullOrEmptyArgumentException Custom exception class.
     */
    public ParkingAccessTicket(String garageName) throws NullOrEmptyArgumentException {
        if(garageName == null || garageName.isEmpty()){
            throw new NullOrEmptyArgumentException("garageName is null or empty in the ParkingAccessTicket constructor");
        }
        this.garage = garageName;
        this.newTicket = new ParkingAccessTicketData(garageName);
    }

    /**
     * Returns garage name.
     * 
     * @return name of the parking garage.
     */
    public final String getGarageName() {
        return garage;
    }


    /**
     * Returns the cars ID.
     * 
     * @return ID of the car associated with the ticket.
     */
    
    public final int getCarID() {
        return newTicket.getCarID();
    }


     /**
     * Gets the original date that the car printed the ticket. 
     * this version returns the LocalDateTime.
     * @return the date the ticket was issued.
     */
    public final LocalDateTime getDateOfAccess(){
        return newTicket.getTicketDate();
    }

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.newTicket);
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
        final ParkingAccessTicket other = (ParkingAccessTicket) obj;
        if (!Objects.equals(this.newTicket, other.newTicket)) {
            return false;
        }
        return true;
    }
}
