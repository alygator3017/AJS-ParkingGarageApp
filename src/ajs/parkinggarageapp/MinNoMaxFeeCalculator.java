package ajs.parkinggarageapp;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ajSchmidt-Zimmel
 */
public class MinNoMaxFeeCalculator implements FeeCalculatorStrategy {

    private double fee;
    private double hours;
    private final OutputService errorPrinter;

//    public MinNoMaxFeeCalculator(double hours) {
//        try {
//            setHours(hours);
//        } catch (NullOrEmptyArgumentException e) {
//            System.out.println(e);
//        }
//        //wouldn't allow anything without a try catch
//        try{
//        totalFee();
//        }catch (NullOrEmptyArgumentException e ){
//            System.out.println(e);
//        }
//    }

    /**
     *
     * @param errorPrinter
     */
    
    public MinNoMaxFeeCalculator(OutputService errorPrinter) {
        this.errorPrinter = errorPrinter;
    }

    private void minFee() {
        double minFee = 1.50;
        fee += minFee;
    }

    private void addFee(double hours) throws NumberOutOfRangeException {
        if (hours <= 0 || hours > 24) {
            throw new NumberOutOfRangeException("Hours cannot be above 24 or below/equal to zero. addFee method MinNoMaxFeeCalculator.");
        }
        for (int i = 2; i < hours; i++) {
            fee += 0.75;
        }
    }

    /**
     * Sets the hour to be charged.
     * @param hours Hours to be charged.
     * @throws NumberOutOfRangeException Custom exception class.
     */
    @Override
    public final void setHours(double hours) throws NumberOutOfRangeException {
        if (hours > 24 || hours <= 0.0) {
            try {
                throw new NumberOutOfRangeException("Hours cannot be above 24 or below/equal to zero. addFee method MinNoMaxFeeCalculator.");
            } catch (NumberOutOfRangeException ex) {
                try {
                    errorPrinter.outputData(ex.toString());
                } catch (NullOrEmptyArgumentException ex1) {
                    errorPrinter.outputData(ex1);
                }
            }
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

    private void totalFee() throws NumberOutOfRangeException {
        if (getHours() < 2) {
            minFee();
        } else {
            minFee();
            addFee(getHours());
        }
    }

    /**
     * Sets the hour to be charged.
     * @param hours Hours to be charged.
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
        //wouldn't allow anything without a try catch
        try {
            totalFee();
        }  catch (NumberOutOfRangeException ex) {
            try {
                errorPrinter.outputData(ex.toString());
            } catch (NullOrEmptyArgumentException ex1) {
                errorPrinter.outputData(ex1);
            }
        }
        
        return fee;
    }
}
