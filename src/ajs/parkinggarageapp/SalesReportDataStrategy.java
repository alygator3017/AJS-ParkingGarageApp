package ajs.parkinggarageapp;

/**
 * Sales report data strategy interferace file. 
 * @author ajSchmidt-Zimmel
 * @version 1.2
 */
public interface SalesReportDataStrategy {

    public abstract void newCar(double hours, double fee) throws NullOrEmptyArgumentException;
    
    public abstract void clearTotals();

    public abstract String output();
    
}
