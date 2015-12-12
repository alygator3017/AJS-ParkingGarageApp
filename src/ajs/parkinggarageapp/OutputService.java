package ajs.parkinggarageapp;

import java.util.Objects;

/**
 * Output service used in conjunction with the Output strategy. 
 * This method takes an output strategy and creates a new output service, along
 * with sending the data to be output to that specified output strategy.
 * @author ajSchmidt-Zimmel
 * @version 1.2
 */
public class OutputService {

    private final OutputStrategy outputType;

    /**
     * Constructor for Output service.
     * This constructor takes and assigns the specified output strategy.
     * the output cannot be null. 
     * @param output Output strategy to be used.
     * @throws ajs.parkinggarageapp.NullOrEmptyArgumentException Custom exception class.
     */
    public OutputService(OutputStrategy output) throws NullOrEmptyArgumentException {
        if(output == null){
            throw new NullOrEmptyArgumentException("output cannot be null in the OutputService constructor.");
        }
        this.outputType = output;
    }

    /**
     * Sends the data to the output strategy to be output.
     * Data cannot be null. 
     * @param data The data string to be sent to the output strategy.
     * @throws NullOrEmptyArgumentException Custom exception class.
     */
    public final void outputData(String data) throws NullOrEmptyArgumentException {
        if (data == null || data.isEmpty()) {
            throw new NullOrEmptyArgumentException("data string is null or empty in the outputData method of OutputService.");
        }
        try {
            outputType.outputData(data);
        } catch (NullOrEmptyArgumentException e) {
            outputType.outputData(e.toString() + " failed to output data in outputData method in OutputService.");
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

    /**
     * Output for null or empty argument exception.
     * @param e Exception.
     * @throws ajs.parkinggarageapp.NullOrEmptyArgumentException Custom exception class.
     */
    public final void outputData(NullOrEmptyArgumentException e) throws NullOrEmptyArgumentException{
        outputType.outputData(e.toString());
    }
    
    /**
     * Output for number out of range exception.
     * @param e exception.
     * @throws ajs.parkinggarageapp.NullOrEmptyArgumentException Custom exception class.
     */
    public final void outputData(NumberOutOfRangeException e) throws NullOrEmptyArgumentException{
        outputType.outputData(e.toString());
    }

}
