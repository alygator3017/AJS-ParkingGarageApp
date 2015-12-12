package ajs.parkinggarageapp;

import java.util.Objects;

/**
 * Sales Report class is part of the sales report strategy.
 * Adds info to the sales report data and controls the output Location.
 * @author ajSchmidt-Zimmel
 */
public class SalesReport implements SalesReportStrategy {

    private final SalesReportDataStrategy salesReport;
    
    /**
     * Sales report constructor.
     * creates a new sales report.
     * @param garageName Name of the garage
     * @throws NullOrEmptyArgumentException Custom exception class.
     */
    public SalesReport(String garageName) throws NullOrEmptyArgumentException { 
        
        //PROBLEM LINE WHY DID I WRITE THIS NONSENSE
        this.salesReport = new NewSalesReport(garageName);
    }

    

    /**
     * Adding data to cumulative daily sales report.
     * hours cannot be less than 0 or greater than 24 and fee cannot be less than 1.50
     * @param hours hours car was parked.
     * @param fee Fee's incurred during that time.
     * @throws NullOrEmptyArgumentException
     */
        @Override
    public void addToSalesReport(double hours, double fee) throws NullOrEmptyArgumentException {
        if (hours <= 0 || hours > 24 || fee < 1.50) {
            throw new NullOrEmptyArgumentException(" hours or fee is out of range: Sales Report addToSalesReport method");
        }
        try {
            salesReport.newCar(hours, fee);
        } catch (NullOrEmptyArgumentException e) {
            //endless try catch
            System.out.println("Cannot pass hours of fee because one or more are null to new car method inside addToSalesReport");
        }
    }

    /**
     * Outputs data to output service.
     * outputType cannot be null.
     * @param outputType Output strategy being used.
     * @throws NullOrEmptyArgumentException Custom exception class.
     */
    @Override
    public void output(OutputService outputType) throws NullOrEmptyArgumentException {
        if (outputType == null) {
            throw new NullOrEmptyArgumentException("outputType is null in output in SalesReport");
        }
        try {
            outputType.outputData(salesReport.output());
        } catch (NullOrEmptyArgumentException e) {
            System.out.println(e + " could not output in output in SalesReport.");
        }

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.salesReport);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SalesReport other = (SalesReport) obj;
        if (!Objects.equals(this.salesReport, other.salesReport)) {
            return false;
        }
        return true;
    }

}
