package ajs.parkinggarageapp;

import java.util.Objects;

/**
 *
 * @author Alyson
 */
public class TicketDispenserTerminal implements ParkingTicketTerminalStrategy {

    private final Output ticketOutput;

    public TicketDispenserTerminal(Output ticketOutput) {
        this.ticketOutput = ticketOutput;
    }

    public final void newTicket(String garageName, int carID, double hours, double fee, String date) throws IllegalArgumentException {
        if (garageName == null || garageName.isEmpty() || carID <= 0 || hours <= 0 || hours > 24 || fee < 1.50 || date == null || date.isEmpty()) {
            throw new IllegalArgumentException();
        }
        ticketTransaction(garageName, carID, hours, fee, date);

    }

    @Override
    public final void ticketTransaction(String garageName, int carID, double hours, double fee, String date) throws IllegalArgumentException {
        if (garageName == null || garageName.isEmpty() || carID <= 0 || hours <= 0 || hours > 24 || fee < 1.50 || date == null || date.isEmpty()) {
            throw new IllegalArgumentException();
        }
        TerminalOutputTypeStrategy dataOutput = new TicketDataOutput(garageName, carID, date);
        try {
            dataOutput.output(ticketOutput);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.ticketOutput);
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
        final TicketDispenserTerminal other = (TicketDispenserTerminal) obj;
        if (!Objects.equals(this.ticketOutput, other.ticketOutput)) {
            return false;
        }
        return true;
    }

}
