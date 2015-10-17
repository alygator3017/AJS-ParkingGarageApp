package ajs.parkinggarageapp;

import java.util.Objects;

/**
 *
 * @author Alyson
 */
public class SalesReportPrinter {

    private SalesReportOutputStrategy salesReport;
    private final String garageName;
    private final Output output;

    public SalesReportPrinter(Output output, String garageName) throws IllegalArgumentException {
        if(output == null || garageName == null || garageName.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.garageName = garageName;
        this.output = output;
    }

    public final void startNewDay() {
        this.salesReport = new SalesReport(garageName);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.output);
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
        final SalesReportPrinter other = (SalesReportPrinter) obj;
        return Objects.equals(this.output, other.output);
    }
    
}
