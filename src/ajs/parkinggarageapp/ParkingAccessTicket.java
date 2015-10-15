package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class ParkingAccessTicket {
    private final ParkingAccessTicketDataStrategy newTicket;
//    private final OutputStrategy output;

    public ParkingAccessTicket( String garageName, FeeCalculatorStrategy fee) {
        this.newTicket = new ParkingAccessTicketData(new GarageName(garageName), fee );
    }

    public ParkingAccessTicketDataStrategy getTicket() {
        return newTicket;
    }
    
    
    public static void main(String[] args) {
        ParkingAccessTicket test = new ParkingAccessTicket("Herbies", new MinNoMaxFeeCalculator(8));
         System.out.println(test.getTicket().ticketData());
    }
}
