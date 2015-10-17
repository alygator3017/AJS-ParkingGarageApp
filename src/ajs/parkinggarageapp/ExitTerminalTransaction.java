package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class ExitTerminalTransaction implements ParkingTicketTerminalStrategy {

    private final Output salesReportOutput;
    private final Output receiptOutput;
    private final Output displayOutput;
    private final SalesReportOutputTypeStrategy outputSalesReport;

    public ExitTerminalTransaction(Output displayOutput, Output receiptOutput, Output salesReport, String garageName) {
        this.displayOutput = displayOutput;
        this.receiptOutput = receiptOutput;
        this.salesReportOutput = salesReport;
        this.outputSalesReport = new SalesReport(garageName);
    } 

    @Override
    public final void ticketTransaction(String garageName, int carID, double hours, double fee, String date) {
        TerminalOutputTypeStrategy outputFeeDisplay = new ExitTerminalDisplayTicketInfoAndFeeTotal(garageName, carID, hours, fee);
        TerminalOutputTypeStrategy outputReceipt = new Receipt(garageName, carID, hours, fee);
        TerminalOutputTypeStrategy outputReceiptDisplay = new ExitTerminalDisplayReceipt(garageName, carID, hours, fee);
        displayFeeDue(outputFeeDisplay);
        outputReceipt(outputReceipt);
        displayReceipt(outputReceiptDisplay);
        outputSalesReport(outputSalesReport, hours, fee);
    }

    private void displayFeeDue(TerminalOutputTypeStrategy display) {
        display.output(displayOutput);
    }

    private void outputReceipt(TerminalOutputTypeStrategy outputReceipt) {
        outputReceipt.output(receiptOutput);
    }

    private void displayReceipt(TerminalOutputTypeStrategy display) {
        display.output(displayOutput);
    }

    private void outputSalesReport(SalesReportOutputTypeStrategy sr, double hours, double fee) {
        sr.addToSalesReport(hours, fee);
        sr.output(salesReportOutput);
    }

//    public static void main(String[] args) {
//        Output consoleOutput = new Output(new ConsoleOutput());
//        Output jOptionPaneOutput = new Output(new JOptionPaneOutput());
//        GarageName name = new GarageName("Hebies");
//
//        ParkingAccessTicket car1 = new ParkingAccessTicket(name.getName(), new FeeCalculator(new MinNoMaxFeeCalculator(8)));
//        ParkingAccessTicket car2 = new ParkingAccessTicket(name.getName(), new FeeCalculator(new MinNoMaxFeeCalculator(8)));
//        ParkingAccessTicket car3 = new ParkingAccessTicket(name.getName(), new FeeCalculator(new MinNoMaxFeeCalculator(8)));
//
//        ExitTerminalTransaction exit = new ExitTerminalTransaction(jOptionPaneOutput, consoleOutput, consoleOutput, name.getName());
//        exit.ticketTransaction(car1.getGarageName(), car1.getCarID(), car1.getHours(), car1.getFee(), car1.getDateOfAccess());
//        exit.ticketTransaction(car2.getGarageName(), car2.getCarID(), car2.getHours(), car2.getFee(), car2.getDateOfAccess());
//    }

}
