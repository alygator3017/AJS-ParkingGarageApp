package ajs.parkinggarageapp.extras;

import ajs.parkinggarageapp.Output;
import ajs.parkinggarageapp.TerminalOutputStrategy;
import java.text.NumberFormat;

/**
 *
 * @author Alyson
 */
class ExitTerminalDisplayTicketInfoAndFeeTotal implements TerminalOutputStrategy {

    private static final String DASHED = "======================================";
    private final double fee;
    private final double hours;
    private final int carID;
    private final String garageName;

    public ExitTerminalDisplayTicketInfoAndFeeTotal(String garageName, int carID, double hours, double fee) {
        this.garageName = garageName;
        this.carID = carID;
        this.hours = hours;
        this.fee = fee;
    }

    private String getDisplayData() {
        NumberFormat curr = NumberFormat.getCurrencyInstance();
        NumberFormat h = NumberFormat.getNumberInstance();
        final String newLine = "\n";
        StringBuilder receiptData = new StringBuilder();
        receiptData.append(garageName).append(newLine);
        receiptData.append("Ticket information").append(newLine);
        receiptData.append(DASHED).append(newLine);
        receiptData.append("Car ID: ").append(carID).append(newLine);
        receiptData.append("Total Hours Billed: ").append(h.format(hours)).append(newLine);
        receiptData.append("Total Fee Due: ").append(curr.format(fee)).append(newLine);
        String data = receiptData.toString();
        return data;
    }

    @Override
    public void output(Output output) throws ajs.parkinggarageapp.IllegalArgumentException {
        if (output == null) {
            throw new IllegalArgumentException();
        }
        try {
            output.outputData(getDisplayData());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
