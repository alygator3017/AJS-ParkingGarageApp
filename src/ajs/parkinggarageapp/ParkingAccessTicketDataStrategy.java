package ajs.parkinggarageapp;

import java.time.LocalDateTime;

/**
 * Interface for the ticket data strategy.
 * @author ajSchmidt-Zimmel
 */
public interface ParkingAccessTicketDataStrategy{

    public abstract int getCarID();

    public abstract String getGarageName();
    
    public abstract LocalDateTime getTicketDate();

    public abstract void newTicket();
    
}
