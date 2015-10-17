package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class SalesReport implements SalesReportOutputTypeStrategy{
    private final SalesReportStrategy salesReport;
    
    //hours
    //fee
    
    public SalesReport( String garageName){
        this.salesReport = new NewSalesReport(garageName);
    }
    
    @Override
    public void addToSalesReport(double hours, double fee){
        salesReport.newCar(hours, fee);
    }

    @Override
    public void output(Output outputType) {
        outputType.outputData(salesReport.output());
        
    }

    
    public static void main(String[] args) {
        SalesReport sr = new SalesReport("Herbies");
        sr.addToSalesReport(8, 24);
        sr.addToSalesReport(8, 24);
        sr.addToSalesReport(8, 24);
        sr.output(new Output(new ConsoleOutput()));
    }
}
