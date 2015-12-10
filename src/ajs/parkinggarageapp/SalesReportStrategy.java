package ajs.parkinggarageapp;

/**
 *
 * @author ajSchmidt-Zimmel
 */
public interface SalesReportStrategy {

    public abstract void newCar(double hours, double fee) throws NullOrEmptyArgumentException;

    public abstract String output();
    
}
