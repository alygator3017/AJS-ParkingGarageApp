package ajs.parkinggarageapp;

import java.util.Objects;

/**
 *
 * @author Alyson
 */
public class ParkingAccessTicket {

    private final ParkingAccessTicketDataStrategy newTicket;
//    private final OutputStrategy output;

    public ParkingAccessTicket(String garageName, FeeCalculator fee) { 
        this.newTicket = new ParkingAccessTicketData(new CustomGarageName(garageName), fee);
    }

    public final String getGarageName() {
        return newTicket.getGarageName();
    }

    public final double getHours() {
        return newTicket.getHours();
    }

    public final int getCarID() {
        return newTicket.getCarID();
    }

    /**
     * Gets the original date that the car printed the ticket. THIS IS ONLY FOR
     * FUTURE USE (not used in this project since we aren't doing any date
     * calculations.)
     *
     * @return the date String.
     */
    public final String getDateOfAccess() {
        return newTicket.getTicketDate();
    }

    public final double getFee() {
        return newTicket.getFeeCalculator().getFee();
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
