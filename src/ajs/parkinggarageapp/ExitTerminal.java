package ajs.parkinggarageapp;

import java.util.Objects;

/**
 *
 * @author Alyson
 */
public class ExitTerminal implements ParkingTicketTerminalStrategy {

    private final Output salesReportOutput;
    private final Output receiptOutput;
////    only to be uncommented if using one of the display classes for a terminal display
//    private final Output displayOutput;
    private final SalesReportOutputStrategy outputSalesReport;

    public ExitTerminal(Output displayOutput, Output receiptOutput, Output salesReport, String garageName) { 
////      only to be uncommented if using one of the display classes for a terminal display
////      a display output parameter should be added to this method's paramenter
//        this.displayOutput = displayOutput;
        this.receiptOutput = receiptOutput;
        this.salesReportOutput = salesReport;
        this.outputSalesReport = new SalesReport(garageName);
    }

    @Override
    public final void ticketTransaction(String garageName, int carID, double hours, double fee, String date) throws IllegalArgumentException {
        if (carID < 0 || hours <= 0 || hours > 24 || fee < 1.50 || date == null || date.isEmpty()) {
            throw new IllegalArgumentException();
        }
        TerminalOutputStrategy outputReceipt = new Receipt(garageName, carID, hours, fee);
        try {
            outputReceipt(outputReceipt);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            outputSalesReport(outputSalesReport, hours, fee);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    /**
     * Method used in order to display the fee on a display screen. since this
     * is not a requirement in the program at this time it is commented out. May
     * be un-commented and ExitTerminalDisplayTicketInfoAndFee moved to main
     * ajs-parkinggarageapp folder. This class must be instantiated inside the
     * ticket transaction method and then call he output method from that class.
     *
     * @param display
     */
//    private void displayFeeDue(TerminalOutputStrategy display) throws IllegalArgumentException{
//        if(display == null){
//          throw new IllegalArgumentException();
//        }
//        display.output(displayOutput);
//    }
    private void outputReceipt(TerminalOutputStrategy outputReceipt) throws IllegalArgumentException {
        if (outputReceipt == null) {
            throw new IllegalArgumentException();
        }
        try {
            outputReceipt.output(receiptOutput);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    /**
     * Method used in order to display the receipt on a display screen. since
     * this is not a requirement in the program at this time it is commented
     * out. May be un-commented and ExitTerminalDisplayReceipt moved to main
     * ajs-parkinggarageapp folder. This class must be instantiated inside the
     * ticket transaction method and then call he output method from that class.
     *
     * @param display
     */
//    private void displayReceipt(TerminalOutputStrategy display) {
//        if(display == null){
//          throw new IllegalArgumentException();
//        }
//        display.output(displayOutput);
//    }
    private void outputSalesReport(SalesReportOutputStrategy sr, double hours, double fee) throws IllegalArgumentException {
        if (sr == null || hours <= 0 || hours > 24 || fee < 1.50) {
            throw new IllegalArgumentException();
        }
        try {
            sr.addToSalesReport(hours, fee);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            sr.output(salesReportOutput);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    @Override
    public final int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.salesReportOutput);
        hash = 37 * hash + Objects.hashCode(this.receiptOutput);
        hash = 37 * hash + Objects.hashCode(this.outputSalesReport);
        return hash;
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExitTerminal other = (ExitTerminal) obj;
        if (!Objects.equals(this.salesReportOutput, other.salesReportOutput)) {
            return false;
        }
        if (!Objects.equals(this.receiptOutput, other.receiptOutput)) {
            return false;
        }
        if (!Objects.equals(this.outputSalesReport, other.outputSalesReport)) {
            return false;
        }
        return true;
    }

}
