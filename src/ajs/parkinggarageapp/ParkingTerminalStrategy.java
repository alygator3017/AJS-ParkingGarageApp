package ajs.parkinggarageapp;

import java.time.LocalDateTime;

/**
 *
 * @author ajSchmidt-Zimmel
 */
public interface ParkingTerminalStrategy {

    public abstract void ticketTransaction(String garageName, int carID, String sDate, LocalDateTime date) throws NullOrEmptyArgumentException;
    
}
