package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class StartUp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GarageNameStrategy g = new GarageName("Herbies");
        String garageName = g.getName();
        
        ParkingTerminal pt = new ParkingTerminal(new ConsoleOutput(), new ConsoleOutput(), new JOptionPaneOutput(), new ConsoleOutput(), g);
        pt.startNewDay();
        
        ParkingAccessTicket car1 = new ParkingAccessTicket(garageName, new MinNoMaxFeeCalculator(8));
        ParkingAccessTicket car2 = new ParkingAccessTicket(garageName, new MinNoMaxFeeCalculator(8));
        ParkingAccessTicket car3 = new ParkingAccessTicket(garageName, new MinNoMaxFeeCalculator(8));
        ParkingAccessTicket car4 = new ParkingAccessTicket(garageName, new MinNoMaxFeeCalculator(8));
        
        pt.newParkingTicket(car1);
        pt.newParkingTicket(car2);
        pt.newParkingTicket(car3);
        pt.newParkingTicket(car4);
        pt.exitParkingGarage(car1);
        pt.exitParkingGarage(car2);
        pt.exitParkingGarage(car3);
        pt.exitParkingGarage(car4);
    }
    
}
