package ajs.parkinggarageapp;

/**
 *
 * @author ajSchmidt-Zimmel
 */
public interface FeeCalculatorStrategy {
    
    public abstract void setHours(double hours) throws NumberOutOfRangeException;
    
    public abstract double getHours();

    public abstract double getTotalFee(double hours);
    
}
