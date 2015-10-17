package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class IllegalArgumentException extends Exception {
    private final static String MSG = "Illegal Argument";
    public IllegalArgumentException() {
        super(MSG);
    }

    public IllegalArgumentException(String string) {
        super(MSG);
    }

    public IllegalArgumentException(String string, Throwable thrwbl) {
        super(MSG, thrwbl);
    }

    public IllegalArgumentException(Throwable thrwbl) {
        super(MSG, thrwbl);
    }
    
}
