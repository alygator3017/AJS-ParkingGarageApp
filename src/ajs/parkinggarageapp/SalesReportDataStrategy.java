package ajs.parkinggarageapp;

/**
 * Sales report data strategy interface file. 
 * @author ajSchmidt-Zimmel
 * @version 1.2
 */
public interface SalesReportDataStrategy {

    public abstract void newCar(double hours, double fee) throws NullOrEmptyArgumentException;
    
    public abstract double getTotalDailySales();
    
    public abstract double getTotalDailyHours();
    
    public abstract int getTotalDailyCars();

    public abstract String output();
    
}
