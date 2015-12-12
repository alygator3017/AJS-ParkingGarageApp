package ajs.parkinggarageapp;

/**
 * Factory creator for FeeCalculatorStrategy. 
 * Creates fee calculator strategy objects based on enum representing the two strategy classes
 * Uses singleton to create only ONE instance of the of a fee calculator strategy class. 
 * @author Alyson
 */
public class FeeCalculatorFactory {

    /**
     * Enum representing the Fee calculator strategy classes.
     */
    public static enum FeeCalculators {
        MINNOMAX, MINMAX
    }
    
    private static FeeCalculatorFactory instance;
    private FeeCalculatorFactory(){
        
    }
    
    /**
     * Gets one instance of the class.
     * @return the instance of the class.
     */
    public static FeeCalculatorFactory getInstance(){
        if(instance == null) {
            instance = new FeeCalculatorFactory();
        }
        return instance;
    }
    
    /**
     * Creates a fee calculator based on the enums. 
     * @param calculatorType ex FeeCalculatorFactory.FeeCalculators.MINNOMAX
     * @param output where the fee calculator should output.
     * @return the feeCalculatorStrategy.
     * @throws NullOrEmptyArgumentException Custom Exception Class.
     */
    public final FeeCalculatorStrategy getFeeCalculator(FeeCalculators calculatorType, OutputService output) throws NullOrEmptyArgumentException{
        if(calculatorType == null || output == null){
            throw new NullOrEmptyArgumentException("calculatorType and output cannot be null.");
        }
        FeeCalculatorStrategy feeCalc = null;
        
        switch(calculatorType) {
            case MINNOMAX:
                feeCalc = new MinNoMaxFeeCalculator(output);
                break;
            case MINMAX:
                feeCalc = new MinMaxFeeCalculator(output);
                break;
        }
        
        return feeCalc;
    }
}
