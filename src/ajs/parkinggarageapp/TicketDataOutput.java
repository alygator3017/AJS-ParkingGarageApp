package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class TicketDataOutput implements TerminalOutputStrategy {

    private static final String DASHED = "======================================";
    private String ticketData;

    public TicketDataOutput(String garageName, int carID, String date) {
        ticketData = "";
        try {
            ticketData = ticketData(garageName, carID, date);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    @Override
    public final void output(Output output) throws IllegalArgumentException {
        if (output == null) {
            throw new IllegalArgumentException();
        }
        try {
            output.outputData(ticketData);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public final String ticketData(String garageName, int carID, String date) throws IllegalArgumentException {
        if (garageName == null || garageName.isEmpty() || carID <= 0 || date == null || date.isEmpty()) {
            throw new IllegalArgumentException();
        }
        final String newLine = "\n";
        StringBuilder sbData = new StringBuilder(DASHED).append(newLine);
        sbData.append(garageName).append("\n").append(newLine);
        sbData.append("Car ID: ").append(carID).append(newLine);
        sbData.append("Entered garage on: ").append(date).append(newLine);
        sbData.append(DASHED).append(newLine);
        String data = sbData.toString();
        return data;
    }

}
