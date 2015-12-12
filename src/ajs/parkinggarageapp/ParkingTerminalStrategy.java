package ajs.parkinggarageapp;

import java.time.LocalDateTime;

/**
 * Parking Terminal Strategy Interface.
 * @author ajSchmidt-Zimmel
 * @version 1.2
 */
public interface ParkingTerminalStrategy {

    public abstract void ticketTransaction(String garageName, int carID, String sDate, LocalDateTime date) throws NullOrEmptyArgumentException;
    
}
