package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class Output {

    private final OutputStrategy output;
    
    public Output(OutputStrategy output){
        this.output = output;
    }
    
    public void outputData(String data){
        output.outputData(data);
    }
    
}
