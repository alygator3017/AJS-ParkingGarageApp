package ajs.parkinggarageapp;

import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * Min Max Fee Calculator for the Fee Calculator Strategy. 
 * Calculates the fee based on the Min Max calculations. The Min Max calculations
 * are as follows: min fee is 2.00, max fee is 10.00, ever hour charges .50 cents.
 * If the hours are less than 3 hours then minimum fee will be charged. Only charges for 
 * up to 24 hours.
 * @author ajSchmidt-Zimmel
 */
public class MinMaxFeeCalculator implements FeeCalculatorStrategy {

    private double fee;
    private double hours;
    private final OutputService errorPrinter;


    /**
     * Constructor for MinMaxFeeCalculator.
     * errorPrinter cannot be null.
     * @param errorPrinter output service for error
     * @throws ajs.parkinggarageapp.NullOrEmptyArgumentException custom exception class
     */
    public MinMaxFeeCalculator(OutputService errorPrinter) throws NullOrEmptyArgumentException {
        if(errorPrinter == null){
            throw new NullOrEmptyArgumentException("errorPrinter in MinMaxFeeCalculator constructor is null");
        }
        this.errorPrinter = errorPrinter;
    }
    
    

    private void minFee() {
        double minFee = 2.00;
        fee += minFee;
    }

    private void addFee() {
        double maxFee = 10.00;
        for (int i = 3; i < getHours(); i++) {
            if (fee < maxFee) {
                fee += 0.50;
                //fee will never go over
                if (fee > maxFee) {
                    fee = maxFee;
                }
            } else {
                fee = maxFee;
            }

        }
    }

    private void totalFee() {
        if (getHours() < 3) {
            minFee();
        } else {
            minFee();
            addFee();
        }
    }

    /**
     * Returns the total fee to be charged. 
     * @param hours Hours car was parked.
     * @return The fee to be charged.
     * @throws ajs.parkinggarageapp.NumberOutOfRangeException
     */ 
    @Override
    public final double getTotalFee(double hours) {
        if(hours <= 0 || hours > 24){
            try {
                throw new NumberOutOfRangeException("hours cannot be less or equal to 0 or greater than 24 in getTotalFee in MinMaxFeeCalculator");
            } catch (NumberOutOfRangeException ex) {
                try {
                    errorPrinter.outputData(ex.toString() + " number out of range, hours our of range in getTotalFee in MinMaxFeeCalculator.");
                } catch (NullOrEmptyArgumentException ex1) {
                    System.out.println(ex1 + " did not send to printer minMaxFeeCalculator getTotalFee");
                }
            }
        }
        try {
            setHours(hours);
        } catch (NumberOutOfRangeException ex) {
            try {
                errorPrinter.outputData(ex.toString() + " number out of range exception for setHours() in getTotalFee in MinMaxFeeCalculator.");
            } catch (NullOrEmptyArgumentException ex1) {
                System.out.println(ex1 + " problem printing for setting hours.");
            }
        }
        totalFee();
        return fee;
    }

    /**
     * Sets the hour to be charged.
     * @param hours Hours to be charged.
     * @throws NumberOutOfRangeException Custom exception class.
     */
    @Override
    public final void setHours(double hours) throws NumberOutOfRangeException {
        if (hours <= 0 || hours > 24) {
            throw new NumberOutOfRangeException("Hours cannot be above 24 or below/equal to zero. addFee method MinNoMaxFeeCalculator.");
        }
        this.hours = hours;
    }

    /**
     * Gets the number of hours to be charged.
     * @return number of hours to be charged.
     */
    @Override
    public final double getHours() {
        return hours;
    }
}
