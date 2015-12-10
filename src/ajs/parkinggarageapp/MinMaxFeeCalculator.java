package ajs.parkinggarageapp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ajSchmidt-Zimmel
 */
public class MinMaxFeeCalculator implements FeeCalculatorStrategy {

    private double fee;
    private double hours;
    private final OutputService errorPrinter;

//    public MinMaxFeeCalculator(double hours) {
//        try {
//            setHours(hours);
//        } catch (NullOrEmptyArgumentException e) {
//            System.out.println(e);
//        }
//        totalFee();
//    }

    /**
     *
     * @param errorPrinter
     */
    
    public MinMaxFeeCalculator(OutputService errorPrinter) {
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
     */
    @Override
    public final double getTotalFee(double hours) {
        try {
            setHours(hours);
        } catch (NumberOutOfRangeException ex) {
            try {
                errorPrinter.outputData(ex.toString());
            } catch (NullOrEmptyArgumentException ex1) {
                errorPrinter.outputData(ex1);
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
