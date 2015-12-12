package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class OutputFactory {
     /**
     * Enum representing the Fee calculator strategy classes.
     */
    public static enum outputTypes {
        CONSOLE, JOPTIONPANE
    }
    
    private static OutputFactory instance;
    private OutputFactory(){
        
    }
    
    /**
     * Gets one instance of the class.
     * @return the instance of the class.
     */
    public static OutputFactory getInstance(){
        if(instance == null) {
            instance = new OutputFactory();
        }
        return instance;
    }
    
    public final OutputStrategy getOutput(outputTypes outputType) throws NullOrEmptyArgumentException{
        if(outputType == null){
            throw new NullOrEmptyArgumentException("outputType cannot be null.");
        }
        OutputStrategy output = null;
        
        switch(outputType) {
            case CONSOLE:
                output = new ConsoleOutput();
                break;
            case JOPTIONPANE:
                output = new JOptionPaneOutput();
                break;
        }
        
        return output;
    }
}
