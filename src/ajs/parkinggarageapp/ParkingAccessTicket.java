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
    
    /**
     * Gets the original date that the car printed the ticket.
     * THIS IS ONLY FOR FUTURE USE (not used in this project since
     * we aren't doing any date calculations.)
     * @return the date String.
     */
    public String getDateOfAccess(){
        return newTicket.getTicketDate();
    }
    
    public String getTicketData(){
        return newTicket.ticketData();
    }
    
    
    
    public static void main(String[] args) {
        ParkingAccessTicket test = new ParkingAccessTicket("Herbies", new FeeCalculator("Min No Max", 8));
         System.out.println(test.getTicketData());
    }
}
