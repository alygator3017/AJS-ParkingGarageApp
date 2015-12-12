package ajs.parkinggarageapp;

import java.util.Objects;

/**
 * Fee Calculator to start the Fee Calculator Strategy pattern. 
 * Takes in a strategy object for fee calculation. This cannot be null.
 * @author ajSchmidt-Zimmel
 */
public class FeeCalculator {

    private final FeeCalculatorStrategy fee;

    /**
     * Constructor that takes the strategy object for the fee.
     * Fee cannot be null.
     * @param fee part of the FeeCalculatorStrategy object.
     * @throws ajs.parkinggarageapp.NullOrEmptyArgumentException custom exception class
     */
    public FeeCalculator(FeeCalculatorStrategy fee) throws NullOrEmptyArgumentException {
        if(fee == null){
            throw new NullOrEmptyArgumentException("fee strategy is null in FeeCalculator constructor.");
        }
        this.fee = fee;
    }

    /**
     * Returns the total fee being charged per the number of hours.
     * @param hours Hours to for fee to calculate from. 
     * @return Returns the total fee.
     * @throws ajs.parkinggarageapp.NumberOutOfRangeException
     */
    public final double getFee(double hours) throws NumberOutOfRangeException { 
        if(hours  <= 0){
            throw new NumberOutOfRangeException("hours is out of range in getFee method of FeeCalculator");
        }
        return fee.getTotalFee(hours);
    }

    
    
    @Override
    public final int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.fee);
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
        final FeeCalculator other = (FeeCalculator) obj;
        if (!Objects.equals(this.fee, other.fee)) {
            return false;
        }
        return true;
    }

}
