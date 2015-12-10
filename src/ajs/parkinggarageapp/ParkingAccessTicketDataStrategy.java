package ajs.parkinggarageapp;

import java.time.LocalDateTime;
import java.lang.*;

/**
 *
 * @author ajSchmidt-Zimmel
 */
public interface ParkingAccessTicketDataStrategy{

    public abstract int getCarID();

    public abstract String getGarageName();

    /**
     * wouldn't need for non-fake data
     * @return
     */
//    public abstract double getHours();

//    public abstract String getStringTicketDate();
    
    public abstract LocalDateTime getTicketDate();

    public abstract void newTicket();
    
}
