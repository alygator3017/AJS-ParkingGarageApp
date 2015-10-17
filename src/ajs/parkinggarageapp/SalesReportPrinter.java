package ajs.parkinggarageapp;

import java.util.Objects;

/**
 *
 * @author Alyson
 */
public class SalesReportPrinter {

    private SalesReportOutputTypeStrategy salesReport;
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
        try {
            this.salesReport = new SalesReport(garageName);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
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
        if (!Objects.equals(this.output, other.output)) {
            return false;
        }
        return true;
    }
    
}
