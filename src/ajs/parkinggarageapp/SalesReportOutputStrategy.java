package ajs.parkinggarageapp;

/**
 *
 * @author ajSchmidt-Zimmel
 */
interface SalesReportOutputStrategy {
    public abstract void addToSalesReport(double hours, double fee) throws NullOrEmptyArgumentException;
    public abstract void output(OutputService outputType) throws NullOrEmptyArgumentException;
}
