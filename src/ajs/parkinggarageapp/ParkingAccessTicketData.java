package ajs.parkinggarageapp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Alyson
 */
public class ParkingAccessTicketData implements ParkingAccessTicketDataStrategy {

    private Date currentDateTime;
    private final SimpleDateFormat date = new SimpleDateFormat("EEE, MMM d, yyyy hh:mm aaa");
    private String ticketDate;
    private FeeCalculator fee;
    private static int carIDCounter = 0;
    private int carID;
    //faking hour data for the moment
    private double hours;
    private String garageName;

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
     * @param feeCalculator
     */
    public ParkingAccessTicketData(CustomGarageName garageName, FeeCalculator feeCalculator) {
        try {
            setHours(feeCalculator.getHours());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        newTicket();
        try {
            setGarageName(garageName.getName());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            setFeeCalculator(feeCalculator);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    @Override
    public final void newTicket() {
        carIDCounter++;
        currentDateTime = new Date();
        try {
            setTicketDate(currentDateTime);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        carID = carIDCounter;
    }

    /**
     * wouldn't need for non-fake data
     *
     * @return
     */
    @Override
    public final double getHours() {
        return hours;
    }

    /**
     * wouldn't need for non-fake data
     *
     * @param hours
     */
    private void setHours(double hours) throws IllegalArgumentException {
        if (hours <= 0 || hours > 24) {
            throw new IllegalArgumentException();
        }
        this.hours = hours;
    }

    @Override
    public final String getTicketDate() {
        return ticketDate;
    }

    private void setTicketDate(Date currentDatetime) throws IllegalArgumentException {
        if (currentDateTime == null) {
            throw new IllegalArgumentException();
        }
        this.ticketDate = date.format(currentDateTime);
    }

    @Override
    public final int getCarID() {
        return carID;
    }

    @Override
    public final String getGarageName() {
        return garageName;
    }

    private void setGarageName(String garageName) throws IllegalArgumentException {
        if (garageName == null || garageName.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.garageName = garageName;
    }

    private void setFeeCalculator(FeeCalculator feeCalculator) throws IllegalArgumentException {
        if (feeCalculator == null) {
            throw new IllegalArgumentException();
        }
        fee = feeCalculator;
    }

    @Override
    public final FeeCalculator getFeeCalculator() {
        return fee;
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
