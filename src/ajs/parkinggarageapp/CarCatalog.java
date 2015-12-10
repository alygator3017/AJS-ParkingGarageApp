package ajs.parkinggarageapp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Car catalog that is used to add and remove cars from the garage map. You are
 * able to add a car, to remove a car, get the current car map and reset the map
 * if need be. While the reset button can be useful, it should be used with
 * caution since it will clear out the storage of any cars.
 *
 * @author Alyson
 * @version 1.2
 */
public class CarCatalog {

    private static final Map<Integer, ParkingAccessTicket> carList = new HashMap<>();
    private int cID;
    private LocalDateTime eDate;
    private ParkingAccessTicket newTicket;

    /**
     * Used to call the class
     */
    public CarCatalog() {

    }

    /**
     * Add a new car to the car Map. Uses the carID as a key in a map in order
     * to store data on the car that has entered the lot. This map stores the
     * enter date of the car.
     *
     * @param carID ID of the car used to locate the data in the Map
     * @param newTicket
     * @throws NullOrEmptyArgumentException custom exception class
     */
    public final void addCar(int carID, ParkingAccessTicket newTicket) throws NullOrEmptyArgumentException {
        if (carID <= 0 || newTicket == null) {
            throw new NullOrEmptyArgumentException("CarID or enter date is null or empty");
        }
        this.cID = carID;
        this.newTicket = newTicket;
        carList.put(cID, newTicket);
    }

    /**
     * Used to remove a car from the car map. Uses the car id key to locate the
     * specific record in the map and removes it from the list. This can be used
     * to remove a car that has exited the parking structure.
     *
     * @param carID id of the car used to locate the data in the map
     * @throws ajs.parkinggarageapp.NullOrEmptyArgumentException custom
     * exception class
     */
    public final void removeCare(int carID) throws NullOrEmptyArgumentException {
        if (carID <= 0) {
            throw new NullOrEmptyArgumentException("CarID is less or equal to zero.");
        }
        this.cID = carID;
        carList.remove(cID);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.cID;
        hash = 19 * hash + Objects.hashCode(this.newTicket);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CarCatalog other = (CarCatalog) obj;
        if (this.cID != other.cID) {
            return false;
        }
        if (!Objects.equals(this.newTicket, other.newTicket)) {
            return false;
        }
        return true;
    }



    /**
     * Sends the map of cars.
     * may be used if an entire list of current cars in garage are needed.
     * @return map of cars in garage at current time of call.
     */
    public final Map<Integer, ParkingAccessTicket> getCarList() {
        return carList;
    }

    /**
     * Sends the date of the carID being called.
     * May be used if a specific car's enter date and time is needed.
     * @param carID Id of car to be found.
     * @return The enter date of the car needed to be found.
     */
    public final LocalDateTime getDateOfCar(int carID){
        this.newTicket = carList.get(cID);
        return newTicket.getDateOfAccess();
    }
    
    /**
     * Returns the entire ticket.
     * @param carID Id of car to be found.
     * @return car parking garage ticket.
     */
    public final ParkingAccessTicket getTicket(int carID){
        this.newTicket = carList.get(cID);
        return newTicket;
    }
    
    
    
}
