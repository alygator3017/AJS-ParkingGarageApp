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
        Output console = new Output(new ConsoleOutput());
        Output jOp = new Output(new JOptionPaneOutput());
        GarageName garageName = new GarageName("Best Value Parking Garage");

        ParkingAccessTicket car1 = new ParkingAccessTicket(garageName.getName(), new FeeCalculator(new MinNoMaxFeeCalculator(8)));
        ParkingAccessTicket car2 = new ParkingAccessTicket(garageName.getName(), new FeeCalculator(new MinMaxFeeCalculator(8)));
        ParkingAccessTicket car3 = new ParkingAccessTicket(garageName.getName(), new FeeCalculator(new MinNoMaxFeeCalculator(2)));
        ParkingAccessTicket car4 = new ParkingAccessTicket(garageName.getName(), new FeeCalculator(new MinMaxFeeCalculator(1)));

        ParkingTerminal pt = new ParkingTerminal(console, console, jOp, console, garageName);
        try {
            pt.newParkingTicket(car1);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            pt.newParkingTicket(car2);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            pt.exitParkingGarage(car2);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            pt.newParkingTicket(car3);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            pt.exitParkingGarage(car1);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            pt.newParkingTicket(car4);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            pt.exitParkingGarage(car3);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            pt.exitParkingGarage(car4);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        pt.startNewDay();

        try {
            pt.newParkingTicket(car1);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            pt.newParkingTicket(car2);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            pt.exitParkingGarage(car1);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            pt.exitParkingGarage(car2);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

}
