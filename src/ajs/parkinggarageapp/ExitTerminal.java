package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class ExitTerminal implements ParkingTicketTerminalStrategy {

    private ParkingAccessTicket ticketInfo;
    private final OutputStrategy receiptOutput;
    private final OutputStrategy displayOutput;

    public ExitTerminal(OutputStrategy receiptOutput, OutputStrategy displayOutput) {
        this.receiptOutput = receiptOutput;
        this.displayOutput = displayOutput;
    }
    
    

    @Override
    public void ticketTransaction(ParkingAccessTicket ticket) {
        this.ticketInfo = ticket;
        TerminalOutputTypeStrategy outputFeeDisplay = new ExitTerminalDisplayTicketInfoAndFeeTotal(displayOutput, ticketInfo);
        TerminalOutputTypeStrategy outputReceipt = new Receipt(receiptOutput, ticketInfo);
        TerminalOutputTypeStrategy outputReceiptDisplay = new ExitTerminalDisplayReceipt(displayOutput,ticketInfo);
        displayFeeDue(outputFeeDisplay);
        outputReceipt(outputReceipt);
        displayReceipt(outputReceiptDisplay);

    }

    private void displayFeeDue(TerminalOutputTypeStrategy display) {
        display.output();
    }

    private void outputReceipt(TerminalOutputTypeStrategy outputReceipt) {
        outputReceipt.output();
    }

    private void displayReceipt(TerminalOutputTypeStrategy display) {
        display.output();
    }
    public static void main(String[] args) {
//        GarageNameStrategy name = new GarageName("Best Value Parking Garage");
        OutputStrategy consoleOutput = new ConsoleOutput();
        OutputStrategy jOptionPaneOutput = new JOptionPaneOutput();
//        ParkingTicketTerminalStrategy dispenser = new TicketDispenserTerminal(consoleOutput);
        ParkingAccessTicket ticket1 = new ParkingAccessTicket("Herbies", new MinNoMaxFeeCalculator(8));
//        dispenser.ticketTransaction(ticket1);
//        ParkingAccessTicket ticket2 = new ParkingAccessTicket("Herbies", new MinMaxFeeCalculator(2));
//        dispenser.ticketTransaction(ticket2);
   
        ParkingTicketTerminalStrategy exit = new ExitTerminal(consoleOutput, jOptionPaneOutput);
        exit.ticketTransaction(ticket1);
        
       
        
        
    }

    
}
