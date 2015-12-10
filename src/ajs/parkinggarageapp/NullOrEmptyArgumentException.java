package ajs.parkinggarageapp;

/**
 *
 * @author ajSchmidt-Zimmel
 */
public class NullOrEmptyArgumentException extends Exception {
    private final static String MSG = "Illegal Argument";
    public NullOrEmptyArgumentException() {
        super(MSG);
    }

    public NullOrEmptyArgumentException(String string) {
        super(MSG);
    }

    public NullOrEmptyArgumentException(String string, Throwable thrwbl) {
        super(MSG, thrwbl);
    }

    public NullOrEmptyArgumentException(Throwable thrwbl) {
        super(MSG, thrwbl);
    }
    
}
