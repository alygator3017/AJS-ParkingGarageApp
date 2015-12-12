package ajs.parkinggarageapp.extras.NOT.IN.USE;

import ajs.parkinggarageapp.OutputService;
import ajs.parkinggarageapp.TerminalOutputStrategy;
import java.text.NumberFormat;

/**
 *
 * @author ajSchmidt-Zimmel
 */
public class ExitTerminalDisplayReceipt implements TerminalOutputStrategy {

    private static final String DASHED = "======================================";
    private final double fee;
    private final double hours;
    private final int carID;
    private final String garageName;

    public ExitTerminalDisplayReceipt(String garageName, int carID, double hours, double fee) throws IllegalArgumentException {
        if (garageName == null || garageName.isEmpty() || carID <= 0 || hours <= 0 || hours > 24 || fee < 1.50) {
            throw new IllegalArgumentException();
        }
        this.garageName = garageName;
        this.carID = carID;
        this.hours = hours;
        this.fee = fee;
    }

    private String getDisplayReceipt() {
        NumberFormat curr = NumberFormat.getCurrencyInstance();
        NumberFormat h = NumberFormat.getNumberInstance();
        final String newLine = "\n";
        StringBuilder receiptData = new StringBuilder();
        receiptData.append("Receipt").append(newLine);
        receiptData.append(DASHED).append(newLine);
        receiptData.append(newLine);
        receiptData.append(garageName).append(newLine);
        receiptData.append("Car ID: ").append(carID).append(newLine);
        receiptData.append("Total Hours Billed: ").append(hours).append(newLine);
        receiptData.append("Total Fee: ").append(curr.format(fee)).append(newLine);
        receiptData.append("Thank you for coming to ").append(garageName).append(newLine);
        String data = receiptData.toString();
        return data;
    }

    @Override
    public void output(OutputService output) throws IllegalArgumentException, ajs.parkinggarageapp.NullOrEmptyArgumentException {
        if (output == null) {
            throw new IllegalArgumentException();
        }
        try {
            output.outputData(getDisplayReceipt());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

}
