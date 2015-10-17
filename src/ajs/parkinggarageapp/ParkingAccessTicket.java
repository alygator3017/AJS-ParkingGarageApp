package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class ParkingAccessTicket {
    
    
    
    private final ParkingAccessTicketDataStrategy newTicket;
//    private final OutputStrategy output;

    public ParkingAccessTicket( String garageName, FeeCalculator fee) {
        this.newTicket = new ParkingAccessTicketData(new CustomGarageName(garageName), fee );
    }
    
    public String getGarageName(){
        return newTicket.getGarageName();
    }
    
    public double getHours(){
        return newTicket.getHours();
    }
    
    public int getCarID(){
        return newTicket.getCarID();
    }
    /**
     * Gets the original date that the car printed the ticket.
     * THIS IS ONLY FOR FUTURE USE (not used in this project since
     * we aren't doing any date calculations.)
     * @return the date String.
     */
    public String getDateOfAccess(){
        return newTicket.getTicketDate();
    }
    public double getFee(){
        return newTicket.getFeeCalculator().getFee();
    }
}
