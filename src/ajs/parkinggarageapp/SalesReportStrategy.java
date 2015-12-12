package ajs.parkinggarageapp;

/**
 * Sales report strategy interface class.
 * @author ajSchmidt-Zimmel
 * @version 1.2
 */
interface SalesReportStrategy {
    public abstract void addToSalesReport(double hours, double fee) throws NullOrEmptyArgumentException;
    public abstract double getTotalDailySales();
    public abstract double getTotalDailyHours();
    public abstract int getTotalDailyCars();
    public abstract void output(OutputService outputType) throws NullOrEmptyArgumentException;
}
