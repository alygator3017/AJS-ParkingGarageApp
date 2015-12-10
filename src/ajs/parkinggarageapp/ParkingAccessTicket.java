package ajs.parkinggarageapp;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author ajSchmidt-Zimmel
 */
public class ParkingAccessTicket {

    private final ParkingAccessTicketDataStrategy newTicket;
    private final String garage;
//    private final OutputStrategy output;

    /**
     * Constructor to create a new ticket.
     * Creates a new ticket using liskov's substitution principle.
     * @param garageName data on the parking garage.
     */
    public ParkingAccessTicket(String garageName) { 
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

//    public final double getHours() {
//        return newTicket.getHours();
//    }

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
     * This version returns a string
     * @return the date the ticket was issued.
     */
//    public final String getStringDateOfAccess() {
//        return newTicket.getStringTicketDate();
//    }

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
//    public static void main(Garage[] args) {
//        ParkingAccessTicket ps = new ParkingAccessTicket(new Garage("pv", "2222 sdflasdf asf", "222-222-2222"), new FeeCalculator(new MinNoMaxFeeCalculator(9))); 
//        LocalDateTime ld = ps.getDateOfAccess();
//        System.out.println(ld);
//        System.out.println(ps.getStringDateOfAccess());
//        System.out.println(ps.getGarageName());
//        System.out.println(ps.getFee());
////        System.out.println(ps.getHours()); 
//    }
}
