package ajs.parkinggarageapp;

import java.util.Objects;

/**
 *
 * @author Alyson
 */
public class SalesReport implements SalesReportOutputTypeStrategy {

    private final SalesReportStrategy salesReport;

    public SalesReport(String garageName) { 
        this.salesReport = new NewSalesReport(garageName);
    }

    @Override
    public void addToSalesReport(double hours, double fee) throws IllegalArgumentException {
        if (hours <= 0 || hours > 24 || fee < 1.50) {
            throw new IllegalArgumentException();
        }
        try {
            salesReport.newCar(hours, fee);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    @Override
    public void output(Output outputType) throws IllegalArgumentException {
        if (outputType == null) {
            throw new IllegalArgumentException();
        }
        try {
            outputType.outputData(salesReport.output());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
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
