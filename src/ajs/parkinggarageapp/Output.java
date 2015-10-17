package ajs.parkinggarageapp;

import java.util.Objects;

/**
 *
 * @author Alyson
 */
public class Output {

    private final OutputStrategy outputType;

    public Output(OutputStrategy output) {
        this.outputType = output;
    }

    public final void outputData(String data) throws IllegalArgumentException {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException();
        }
        try {
            outputType.outputData(data);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.outputType);
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
        final Output other = (Output) obj;
        if (!Objects.equals(this.outputType, other.outputType)) {
            return false;
        }
        return true;
    }

}
