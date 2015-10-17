package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public interface ParkingAccessTicketDataStrategy{

    public abstract int getCarID();

    public abstract FeeCalculator getFeeCalculator();

    public abstract String getGarageName();

    /**
     * wouldn't need for non-fake data
     * @return
     */
    public abstract double getHours();

    public abstract String getTicketDate();

    public abstract void newTicket();
    
}
