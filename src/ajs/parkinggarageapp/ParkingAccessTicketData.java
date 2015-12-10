package ajs.parkinggarageapp;

import java.time.LocalDateTime;

import java.util.Objects;
import utilities.DateUtilities;

/**
 *
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
     * this would be the constructor with non-fake data
     *
     * @param output
     */
//    public ParkingAccessTicketData(OutputStrategy output){ 
//       newTicket();
//    }
    /**
     * needed in order to fake data
     *
     * @param garageName
     */
    public ParkingAccessTicketData(String garageName) {

        newTicket();
        try {
            setGarageName(garageName);
        } catch (NullOrEmptyArgumentException e) {
            System.out.println(e);
        }
    }

    @Override
    public final void newTicket() {
        carIDCounter++;
        currentDateTime = LocalDateTime.now();
        try {
            setTicketDate(currentDateTime);
        } catch (NullOrEmptyArgumentException e) {
            System.out.println(e);
        }
        carID = carIDCounter;
    }

//    /**
//     * wouldn't need for non-fake data
//     *
//     * @return
//     */
//    @Override
//    public final double getHours() {
//        return hours;
//    }
//
//    /**
//     * wouldn't need for non-fake data
//     *
//     * @param hours
//     */
//    private void setHours(double hours) throws NullOrEmptyArgumentException {
//        if (hours <= 0 || hours > 24) {
//            throw new NullOrEmptyArgumentException();
//        }
//        this.hours = hours;
//    }

    /**
     *
     * @return
     */
//        @Override
//    public final String getStringTicketDate() {
//        String ticketDate = dateUtilities.toString(currentDateTime, dateFormat);
//        return ticketDate;
//    }

    /**
     *
     * @return
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

    @Override
    public final int getCarID() {
        return carID;
    }

    /**
     *
     * @return
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
