package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public interface FeeCalculatorStrategy {

    public abstract void setHours(double hours) throws IllegalArgumentException;
    
    public abstract double getHours();

    public abstract double getTotalFee();
    
}
