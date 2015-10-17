package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class ExitTerminal implements ParkingTicketTerminalStrategy {

    private final Output salesReportOutput;
    private final Output receiptOutput;
////    only to be uncommented if using one of the display classes for a terminal display
//    private final Output displayOutput;
    private final SalesReportOutputTypeStrategy outputSalesReport;

    public ExitTerminal(Output displayOutput, Output receiptOutput, Output salesReport, String garageName) {
////      only to be uncommented if using one of the display classes for a terminal display
////      a display output parameter should be added to this method's paramenter
//        this.displayOutput = displayOutput;
        this.receiptOutput = receiptOutput;
        this.salesReportOutput = salesReport;
        this.outputSalesReport = new SalesReport(garageName);
    } 

    @Override
    public final void ticketTransaction(String garageName, int carID, double hours, double fee, String date) {
        TerminalOutputTypeStrategy outputReceipt = new Receipt(garageName, carID, hours, fee);
        outputReceipt(outputReceipt);
        outputSalesReport(outputSalesReport, hours, fee);
    }

    /**
     * Method used in order to display the fee on a display screen.
     * since this is not a requirement in the program at this time it is
     * commented out. May be un-commented and ExitTerminalDisplayTicketInfoAndFee
     * moved to main ajs-parkinggarageapp folder. This class must be instantiated
     * inside the ticket transaction method and then call he output method from 
     * that class. 
     * @param display 
     */
//    private void displayFeeDue(TerminalOutputTypeStrategy display) {
//        display.output(displayOutput);
//    }

    private void outputReceipt(TerminalOutputTypeStrategy outputReceipt) {
        outputReceipt.output(receiptOutput);
    }

    /**
     * Method used in order to display the receipt on a display screen.
     * since this is not a requirement in the program at this time it is
     * commented out. May be un-commented and ExitTerminalDisplayReceipt
     * moved to main ajs-parkinggarageapp folder. This class must be instantiated
     * inside the ticket transaction method and then call he output method from 
     * that class. 
     * @param display 
     */
//    private void displayReceipt(TerminalOutputTypeStrategy display) {
//        display.output(displayOutput);
//    }

    private void outputSalesReport(SalesReportOutputTypeStrategy sr, double hours, double fee) {
        sr.addToSalesReport(hours, fee);
        sr.output(salesReportOutput);
    }

}
