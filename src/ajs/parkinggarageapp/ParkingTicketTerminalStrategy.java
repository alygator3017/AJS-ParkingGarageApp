package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public interface ParkingTicketTerminalStrategy {

    public abstract void ticketTransaction(String garageName, int carID, double hours, double fee, String date) throws IllegalArgumentException;
    
}
