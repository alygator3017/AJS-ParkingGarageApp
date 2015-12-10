package ajs.parkinggarageapp;

import java.util.Objects;

/**
 *
 * @author ajSchmidt-Zimmel
 */
public class OutputService {

    private final OutputStrategy outputType;

    public OutputService(OutputStrategy output) {
        this.outputType = output;
    }

    public final void outputData(String data) throws NullOrEmptyArgumentException {
        if (data == null || data.isEmpty()) {
            throw new NullOrEmptyArgumentException();
        }
        try {
            outputType.outputData(data);
        } catch (NullOrEmptyArgumentException e) {
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
        final OutputService other = (OutputService) obj;
        if (!Objects.equals(this.outputType, other.outputType)) {
            return false;
        }
        return true;
    }

    void outputData(NullOrEmptyArgumentException e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
