package ajs.parkinggarageapp;

/**
 * Creates the data to be output for the parking access ticket.
 * Takes the car ID created in the parking ticket, the date and the garage name
 * and creates a "physical" ticket to be printed.
 * @author ajSchmidt-Zimmel
 * @version 1.2
 */
public class TicketDataOutput implements TerminalOutputStrategy {

    private static final String DASHED = "======================================";
    private String ticketData;

    /**
     * TicketDataOutput constructor.
     * 
     * @param garageName Name of the garage.
     * @param carID Id of the car.
     * @param date Date the car entered the garage.
     * @throws ajs.parkinggarageapp.NullOrEmptyArgumentException Custom exception class.
     * @throws ajs.parkinggarageapp.NumberOutOfRangeException Custom exception class.
     */
    public TicketDataOutput(String garageName, int carID, String date) throws NullOrEmptyArgumentException, NumberOutOfRangeException {
        if(garageName == null || date == null || garageName.isEmpty() || date.isEmpty()){
            throw new NullOrEmptyArgumentException("garage name or date string is empty or null in TicketDataOutput constructor.");
        }else if(carID <= 0){
            throw new NumberOutOfRangeException("carID is less than or equal to zzero in the TicketDataOutput constructor");
        }
        ticketData = "";
        try {
            ticketData = ticketData(garageName, carID, date);
        } catch (NullOrEmptyArgumentException e) {
            System.out.println(e + " null exception in TicketDataOutput constructor when trying to assign tickeData.");
        }
    }

    /**
     * Sends the ticket data to the output class assigned.
     * output cannot be null.
     * @param output The output service / strategy assigned. 
     * @throws NullOrEmptyArgumentException Custom exception class.
     */
    @Override
    public final void output(OutputService output) throws NullOrEmptyArgumentException {
        if (output == null) {
            throw new NullOrEmptyArgumentException();
        }
        try {
            output.outputData(ticketData);
        } catch (NullOrEmptyArgumentException e) {
            System.out.println(e + " null when trying to pass ticket data to output in output method in TicketDataOutput.");
        }
    }

    private String ticketData(String garageName, int carID, String date) throws NullOrEmptyArgumentException {
        if (garageName == null || garageName.isEmpty() || carID <= 0 || date == null || date.isEmpty()) {
            throw new NullOrEmptyArgumentException("garage name is null or empty. car ID is less than or equal to 0 or date is null or empty. In tiketData private method in TicketDataOutput.");
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
