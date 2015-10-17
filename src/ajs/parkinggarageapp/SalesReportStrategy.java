package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public interface SalesReportStrategy {

    public abstract void newCar(double hours, double fee) throws IllegalArgumentException;

    public abstract String output();
    
}
