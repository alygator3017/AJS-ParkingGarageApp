package ajs.parkinggarageapp;

import java.util.Objects;

/**
 * SalesReportPrinter class prints the sales report.
 * This class takes the output service and the sales report data and prints it to
 * the specified output service. 
 * @author ajSchmidt-Zimmel
 * @version 1.2
 */
public class SalesReportPrinter {

    private SalesReportStrategy salesReport;
    private final String garageName;
    private final OutputService output;

    /**
     * Sales report printer constructor.
     * Output and garageName cannot be null.
     * @param output Where to output the salesReport.
     * @param garageName Name of the parking garage.
     * @throws NullOrEmptyArgumentException Custom exception class.
     */
    public SalesReportPrinter(OutputService output, String garageName) throws NullOrEmptyArgumentException {
        if(output == null || garageName == null || garageName.isEmpty()){
            throw new NullOrEmptyArgumentException();
        }
        this.garageName = garageName;
        this.output = output;
    }

    /**
     * Starts a new sales report.
     * 
     * @throws NullOrEmptyArgumentException Custom exception class.
     */
    public final void startNewDay() throws NullOrEmptyArgumentException {
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
