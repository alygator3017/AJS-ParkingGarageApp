package ajs.parkinggarageapp;

import java.util.Objects;

/**
 *
 * @author Alyson
 */
public class ParkingTerminal {

    private ParkingTicketTerminalStrategy exit;
    private final Output printerOutput;
    private final String garageName;
    private final ParkingTicketTerminalStrategy enter;
    private final Output receiptOutput;
    private final Output displayOutput;

    public ParkingTerminal(Output ticketOutput, Output receiptOutput, Output displayOutput, Output printerOutput, GarageName garageName) {
        this.exit = new ExitTerminal(displayOutput, receiptOutput, printerOutput, garageName.getName());
        this.enter = new TicketDispenserTerminal(ticketOutput);
        this.printerOutput = printerOutput;
        this.displayOutput = displayOutput;
        this.receiptOutput = receiptOutput;
        this.garageName = garageName.getName();
    }

    public final void startNewDay() {
        this.exit = new ExitTerminal(displayOutput, receiptOutput, printerOutput, garageName);
    }

    public final void newParkingTicket(ParkingAccessTicket ticket) throws IllegalArgumentException {
        if (ticket.getCarID() == 0) {
            throw new IllegalArgumentException();
        }
        try {
            enter.ticketTransaction(ticket.getGarageName(), ticket.getCarID(), ticket.getHours(), ticket.getFee(), ticket.getDateOfAccess());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public final void exitParkingGarage(ParkingAccessTicket ticket) throws IllegalArgumentException {
        if (ticket == null) {
            throw new IllegalArgumentException();
        }
        try {
            exit.ticketTransaction(ticket.getGarageName(), ticket.getCarID(), ticket.getHours(), ticket.getFee(), ticket.getDateOfAccess());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.exit);
        hash = 37 * hash + Objects.hashCode(this.printerOutput);
        hash = 37 * hash + Objects.hashCode(this.enter);
        hash = 37 * hash + Objects.hashCode(this.receiptOutput);
        hash = 37 * hash + Objects.hashCode(this.displayOutput);
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
        final ParkingTerminal other = (ParkingTerminal) obj;
        if (!Objects.equals(this.exit, other.exit)) {
            return false;
        }
        if (!Objects.equals(this.printerOutput, other.printerOutput)) {
            return false;
        }
        if (!Objects.equals(this.enter, other.enter)) {
            return false;
        }
        if (!Objects.equals(this.receiptOutput, other.receiptOutput)) {
            return false;
        }
        if (!Objects.equals(this.displayOutput, other.displayOutput)) {
            return false;
        }
        return true;
    }

}
