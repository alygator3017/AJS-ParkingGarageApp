package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class SalesReportPrinter {

    //start new day
    //get ticket from exit terminal
    //send ticket data (hours and total fee) to sales report
    //send data to exit terminal to be printed
    private SalesReportOutputTypeStrategy salesReport;
    private final String garageName;
    private final Output output;
    
    public SalesReportPrinter(Output output, String garageName){
        this.garageName = garageName;
        this.output = output;
    }
    
    public final void startNewDay(){
        this.salesReport = new SalesReport(garageName);
    }

    public void printReport(double hours, double fee) {
        salesReport.addToSalesReport(hours, fee);
        salesReport.output(output);
    }
    
//    public static void main(String[] args) {
//        SalesReportPrinter sr = new SalesReportPrinter(new Output(new ConsoleOutput()), "Herbies");
//        sr.startNewDay();
//        sr.printReport(8, 24);
//        sr.printReport(8, 24);
//        sr.printReport(8, 24);
//        sr.printReport(8, 24);
//        sr.startNewDay();
//        sr.printReport(8, 24);
//    }
}
