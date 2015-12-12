package ajs.parkinggarageapp;

/**
 * Custom exception class for null or empty arguments.
 * This class was created because of an abundance of arguments that could possibly
 * be null or empty. In order to aid debugging, this method takes a string in which
 * I have used throughout the program to specify the method and class or the constructor
 * for the class it is being used in.
 * @author ajSchmidt-Zimmel
 * @version 1.2
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
