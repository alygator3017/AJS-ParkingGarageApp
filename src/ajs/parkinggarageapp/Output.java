package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class Output {

    private final OutputStrategy outputType;
    
    public Output(OutputStrategy output){
        this.outputType = output;
    }
    
    public void outputData(String data){
        
        outputType.outputData(data);
    }
    
}
