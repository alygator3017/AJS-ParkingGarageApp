package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class NumberOutOfRangeException extends Exception{
    
    private final static String MSG = "Number out of range.";
    public NumberOutOfRangeException() {
        super(MSG);
    }

    public NumberOutOfRangeException(String string) {
        super(MSG);
    }

    public NumberOutOfRangeException(String string, Throwable thrwbl) {
        super(MSG, thrwbl);
    }

    public NumberOutOfRangeException(Throwable thrwbl) {
        super(MSG, thrwbl);
    }
    
}
