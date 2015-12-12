package ajs.parkinggarageapp;

import java.time.LocalDateTime;

import java.util.Objects;
import utilities.DateUtilities;

/**
 * Data to be printed for the parking access ticket.
 * @author ajSchmidt-Zimmel
 */
public class ParkingAccessTicketData implements ParkingAccessTicketDataStrategy {

    private LocalDateTime currentDateTime;
//    private final SimpleDateFormat date = new SimpleDateFormat("EEE, MMM d, yyyy hh:mm aaa");
    String dateFormat = "EEE, MMM d, yyyy hh:mm aaa";
    private FeeCalculator fee;
    private static int carIDCounter = 0;
    private int carID;
    //faking hour data for the moment
    private double hours;
    private String garageName;
    DateUtilities dateUtilities = new DateUtilities();

    
    /**
     * Parking access ticket data constructor.
     * Takes in the garage name and creates a new ticket.
     * Garage name cannot be null or empty. Also sets the garage name.
     *
     * @param garageName Name of the garage.
     * @throws ajs.parkinggarageapp.NullOrEmptyArgumentException Custom exception class.
     */
    public ParkingAccessTicketData(String garageName) throws NullOrEmptyArgumentException {
        if(garageName == null || garageName.isEmpty()){
            throw new NullOrEmptyArgumentException("garageName is Null or Empty in the ParkingAccessTicketData constructor.");
        }
        newTicket();
        try {
            setGarageName(garageName);
        } catch (NullOrEmptyArgumentException e) {
            System.out.println(e);
        }
    }

    /**
     * Creates a new ticket.
     * Increases the car count for the car id's. Sets the current date for the
     * parking access ticket.
     */
    @Override
    public final void newTicket() {
        ++carIDCounter;
        currentDateTime = LocalDateTime.now();
        try {
            setTicketDate(currentDateTime);
        } catch (NullOrEmptyArgumentException e) {
            System.out.println(e);
        }
        carID = carIDCounter;
    }

    /**
     * Retrieves the ticket date for the parking access ticket.
     * This is in LocalDateTime
     * @return returns the ticket creation date.
     */
    @Override
    public final LocalDateTime getTicketDate() {
        return currentDateTime;
    }

    
    private void setTicketDate(LocalDateTime currentDateTime) throws NullOrEmptyArgumentException {
        if (currentDateTime == null) {
            throw new NullOrEmptyArgumentException();
        }
        this.currentDateTime = currentDateTime;
    }

    /**
     * Returns the car Id for the ticket.
     * 
     * @return Car's ID number.
     */
    @Override
    public final int getCarID() {
        return carID;
    }

    /**
     * Returns the name of the parking garage.
     * @return Name of the garage.
     */
    @Override
    public final String getGarageName() {
        return garageName;
    }

    private void setGarageName(String garageName) throws NullOrEmptyArgumentException {
        if (garageName == null || garageName.isEmpty()) {
            throw new NullOrEmptyArgumentException();
        } else {
        }
        this.garageName = garageName;
    }

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.fee);
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
        final ParkingAccessTicketData other = (ParkingAccessTicketData) obj;
        if (!Objects.equals(this.fee, other.fee)) {
            return false;
        }
        return true;
    }

}
