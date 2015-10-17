package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
interface SalesReportOutputTypeStrategy {
    public abstract void addToSalesReport(double hours, double fee);
    public abstract void output(Output outputType);
}
