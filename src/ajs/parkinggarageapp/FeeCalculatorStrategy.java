package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public interface FeeCalculatorStrategy {

    public abstract void setHours(double hours);
    
    public abstract double getHours();

    public abstract double getTotalFee();
    
}
