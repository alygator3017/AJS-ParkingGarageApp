package ajs.parkinggarageapp;

import java.util.Objects;

/**
 *
 * @author Alyson
 */
public class FeeCalculator {

    private final FeeCalculatorStrategy fee;

    public FeeCalculator(FeeCalculatorStrategy fee) {
        this.fee = fee;
    }

    public final double getHours() {
        return fee.getHours();
    }

    public final double getFee() {
        return fee.getTotalFee();
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
