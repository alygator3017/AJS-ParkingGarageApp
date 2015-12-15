package ajs.parkinggarageapp;



/**
 * This class calculates the Min no max fee strategy.
 * Calculates the fee based on the Min No Max calculations. The Min No Max calculations
 * are as follows: Minimum fee is 1.50 for less than 2 hours. .75 cents is added for 
 * every hour after up to 24 hours.
 * @author ajSchmidt-Zimmel
 * @version 1.2
 */
public class MinNoMaxFeeCalculator implements FeeCalculatorStrategy {

    private double fee;
    private double hours;
    private final OutputService errorPrinter;


    /**
     * Constructor for MinNoMaxFeeCalculator.
     * takes and errorPrinter which cannot be null.
     * @param errorPrinter This is where to print an error.
     * @throws ajs.parkinggarageapp.NullOrEmptyArgumentException
     */
    
    public MinNoMaxFeeCalculator(OutputService errorPrinter) throws NullOrEmptyArgumentException {
        if(errorPrinter == null){
            throw new NullOrEmptyArgumentException("errorPrinter cannot be null in MinNoMaxFeeCalculator constructor");
        }
        this.errorPrinter = errorPrinter;
    }

    private void minFee() {
        double minFee = 1.50;
        fee += minFee;
    }

    private void addFee(double hours) throws NumberOutOfRangeException {
        if (hours <= 0) {
            throw new NumberOutOfRangeException("Hours cannot be below/equal to zero. addFee method MinNoMaxFeeCalculator.");
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
        if (hours <= 0.0) {
            try {
                throw new NumberOutOfRangeException("Hours cannot be below/equal to zero. addFee method MinNoMaxFeeCalculator.");
            } catch (NumberOutOfRangeException ex) {
                try {
                    errorPrinter.outputData(ex.toString() + " number out of range exception.... don't know why but in setHours in MinNoMaxFeeCalculator.");
                } catch (NullOrEmptyArgumentException ex1) {
                    System.out.println(ex1 + " could not pass to output because of null. setHours in MinNoMaxFeeCalculator.");
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
     * @return returns total fee due.
     */
    @Override
    public final double getTotalFee(double hours) {
        try {
            setHours(hours);
        } catch (NumberOutOfRangeException ex) {
            try {
                errorPrinter.outputData(ex.toString() + " number out of range exception for setHours in getTotalFee.");
            } catch (NullOrEmptyArgumentException ex1) {
                System.err.println(ex1);
            }
        }
        //wouldn't allow anything without a try catch
        try {
            totalFee();
        }  catch (NumberOutOfRangeException ex) {
            try {
                errorPrinter.outputData(ex.toString() + " problem with totalFee() in getTotalFee method in MinNoMaxFeeCalulator.");
            } catch (NullOrEmptyArgumentException ex1) {
                System.out.println(ex1 + " problem printing to error printer in getTotalFee in MinNoMax");
            }
        }
        
        return fee;
    }
}
