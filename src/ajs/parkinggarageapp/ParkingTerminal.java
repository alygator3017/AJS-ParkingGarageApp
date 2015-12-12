package ajs.parkinggarageapp;

import fileserviceapp.FileService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *  Parking terminal class designed to working with the parking terminal strategy. 
 * Creates new parking terminals, assigns output strategies, generates a file service, 
 * Creates a parking access ticket connection as well as a garage connection and a 
 * car catalog connection in order to access car id's and ticket information for
 * AI GUI interaction.
 * 
 * @author ajSchmidt-Zimmel
 */
public class ParkingTerminal {

    private ParkingTerminalStrategy exit;
    private final OutputService printerOutput;
    private final String garageName;
    private final ParkingTerminalStrategy enter;
    private final OutputService receiptOutput;
    private final File file;
    private final FileService fs;
    private final FeeCalculator feeCalc;
    private ParkingAccessTicket ticket;
    private final Garage garage;
    private final CarCatalog carCatalog;

    /**
     * Sets all of the output's, fee strategy, file service, file and garage
     * data.
     *
     * @param ticketOutput How the ticket will print.
     * @param receiptOutput How the receipt will print.
     * @param garage Garage information including name, address and phone.
     * @param printerOutput Where to print the Sales Report data.
     * @param feeCalc Fee Calculator.
     * @param fileService The file service being used.
     * @param file Which file to put daily totals into.
     * @param carCatalog
     * @throws IOException
     * @throws FileNotFoundException
     * @throws NullOrEmptyArgumentException custom exception class
     */
    public ParkingTerminal(OutputService ticketOutput, OutputService receiptOutput, OutputService printerOutput, Garage garage, FeeCalculator feeCalc, FileService fileService, File file, CarCatalog carCatalog) throws IOException, FileNotFoundException, NullOrEmptyArgumentException {
        this.exit = new ExitTerminal(receiptOutput, printerOutput, garage.getName(), feeCalc, fileService, file);
        this.enter = new DispenserTerminal(ticketOutput);
        this.garage = garage;
        this.garageName = garage.getName();
        this.feeCalc = feeCalc;
        this.fs = fileService;
        this.file = file;
        this.printerOutput = printerOutput;
        this.receiptOutput = receiptOutput;
        this.carCatalog = carCatalog;
    }

    /**
     * Clears the file data for a new day. creates a new exit terminal and
     * clears the data in the file for daily totals.
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws NullOrEmptyArgumentException custom exception class.
     */
    public final void startNewDay() throws IOException, FileNotFoundException, NullOrEmptyArgumentException {
        this.exit = new ExitTerminal(receiptOutput, printerOutput, garageName, feeCalc, fs, file);
        Map<String, String> map = new HashMap<>();
        map.put("TotalFees", "0");
        map.put("TotalHours", "0");
        map.put("TotalCars", "0");
        List<Map> data = new ArrayList();
        data.add(map);
        fs.writeToFile(data, file, false);
    }

    /**
     * Create a new Parking ticket. Creates a new ticket through the enter
     * terminal. Also adds the ticket to the car catalog. The method then processes
     * the ticket transaction through the dispenser for printing of the receipt.
     *
     * @return the new ticket
     * @throws NullOrEmptyArgumentException custom exception class
     */
    public final ParkingAccessTicket newParkingTicket() throws NullOrEmptyArgumentException {
        //create new ticket and add to catalog
        ParkingAccessTicket newTicket = createTicket();
        addCarToCatalog(newTicket);
        //checks for carID makes sure we are incrementing
        if (newTicket.getCarID() <= 0) {
            throw new NullOrEmptyArgumentException("carID in new ticket cannot be less than or equal to zero. There is a problem in incrementation of new ticket");
        }
        try {
            enter.ticketTransaction(newTicket.getGarageName(), newTicket.getCarID(), newTicket.getDateOfAccess().toString(), newTicket.getDateOfAccess());
        } catch (NullOrEmptyArgumentException e) {
            receiptOutput.outputData(e + " null exception for enter.ticketTransaction in newParkingTicket in parking terminal.");
        }
        return newTicket;
    }

    private ParkingAccessTicket createTicket() throws NullOrEmptyArgumentException {
       ParkingAccessTicket newTicket = new ParkingAccessTicket(garageName);
       return newTicket;
    }

    private void addCarToCatalog(ParkingAccessTicket newTicket) throws NullOrEmptyArgumentException {
        carCatalog.addCar(newTicket.getCarID(), newTicket);
    }
    
    /**
     * Returns the car catalog
     * @return car catalog
     */
    public Map<Integer, ParkingAccessTicket> getCarCatalog(){
        return carCatalog.getCarList();
    }

    /**
     * Exits the vehicle and complete the exit transaction from parking garage.
     * compares the exiting carID to the carCatalog then passes the information to 
     * the exit terminal class for processing.
     * @param carID car to be exited from garage
     * @throws NullOrEmptyArgumentException custom exception class
     */
    public final void exitParkingGarage(int carID) throws NullOrEmptyArgumentException {
        if (carID <= 0) {
            throw new NullOrEmptyArgumentException("Cannot have an id less than or equal to 0");
        }
        Map<Integer,ParkingAccessTicket> carCat = getCarCatalog();
        ParkingAccessTicket ticketToExit = carCat.get(carID);
        exit.ticketTransaction(ticketToExit.getGarageName(), ticketToExit.getCarID(), ticketToExit.getDateOfAccess().toString(), ticketToExit.getDateOfAccess());
        carCat.remove(carID);
    }

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.exit);
        hash = 37 * hash + Objects.hashCode(this.printerOutput);
        hash = 37 * hash + Objects.hashCode(this.enter);
        hash = 37 * hash + Objects.hashCode(this.receiptOutput);
        return hash;
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ParkingTerminal other = (ParkingTerminal) obj;
        if (!Objects.equals(this.exit, other.exit)) {
            return false;
        }
        if (!Objects.equals(this.printerOutput, other.printerOutput)) {
            return false;
        }
        if (!Objects.equals(this.enter, other.enter)) {
            return false;
        }
        if (!Objects.equals(this.receiptOutput, other.receiptOutput)) {
            return false;
        }
        return true;
    }

}
