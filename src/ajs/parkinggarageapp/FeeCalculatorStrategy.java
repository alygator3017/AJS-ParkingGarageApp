package ajs.parkinggarageapp;

/**
 * Strategy pattern for fee calculator
 * @author ajSchmidt-Zimmel
 * @version 1.2
 */
public interface FeeCalculatorStrategy {
    
    public abstract void setHours(double hours) throws NumberOutOfRangeException;
    
    public abstract double getHours();

    public abstract double getTotalFee(double hours);
    
}
