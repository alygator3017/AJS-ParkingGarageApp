package ajs.parkinggarageapp;

/**
 * Custom exception class for numbers that are out of range.
 * This is specifically used most often in this program for hours and fees but
 * could be used in other projects for any number out of range. It has been
 * constructed to pinpoint the exact location of an exception, I used the class
 * in such a way which the exception I am handling sends a message with the method
 * and class name or constructor.
 * @author Alyson
 * @version 1.2
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
