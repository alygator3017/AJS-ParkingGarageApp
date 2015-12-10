package ajs.parkinggarageapp;

import java.util.Objects;

/**
 *
 * @author ajSchmidt-Zimmel
 */
public class FeeCalculator {

    private final FeeCalculatorStrategy fee;

    /**
     * Constructor that takes the strategy object for the fee.
     * 
     * @param fee part of the FeeCalculatorStrategy object.
     */
    public FeeCalculator(FeeCalculatorStrategy fee) {
        this.fee = fee;
    }

//    /**
//     * Returns the number of hours charged.
//     * @return Hours to be charged.
//     */
//    public final double getHours() {
//        return fee.getHours();
//    }

    /**
     * Returns the total fee being charged per the number of hours.
     * @return total fee
     */
    public final double getFee(double hours) {
        
        
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
