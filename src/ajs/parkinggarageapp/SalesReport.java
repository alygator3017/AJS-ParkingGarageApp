package ajs.parkinggarageapp;

import java.util.Objects;

/**
 *
 * @author ajSchmidt-Zimmel
 */
public class SalesReport implements SalesReportOutputStrategy {

    private final SalesReportStrategy salesReport;

    public SalesReport(String garageName) { 
        this.salesReport = new NewSalesReport(garageName);
    }

    //add file service in sales report and call that in exit terminal because this is part of the actual sales report
    @Override
    public void addToSalesReport(double hours, double fee) throws NullOrEmptyArgumentException {
        if (hours <= 0 || hours > 24 || fee < 1.50) {
            throw new NullOrEmptyArgumentException();
        }
        try {
            salesReport.newCar(hours, fee);
        } catch (NullOrEmptyArgumentException e) {
            System.out.println(e);
        }
    }

    @Override
    public void output(OutputService outputType) throws NullOrEmptyArgumentException {
        if (outputType == null) {
            throw new NullOrEmptyArgumentException();
        }
        try {
            outputType.outputData(salesReport.output());
        } catch (NullOrEmptyArgumentException e) {
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
