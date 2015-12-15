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

    /**
     * Prints the message.
     */
    public NullOrEmptyArgumentException() {
        super(MSG);
    }

    /**
     * Prints the message brought in.
     * @param string The message to be printed.
     */
    public NullOrEmptyArgumentException(String string) {
        super(string);
    }

    /**
     * Prints the string and throwable.
     * @param string String to be printed.
     * @param thrwbl Throwable being passed.
     */
    public NullOrEmptyArgumentException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    /**
     * Sends the throwable to the super to print out the error.
     * @param thrwbl Throwable to be passed.
     */
    public NullOrEmptyArgumentException(Throwable thrwbl) {
        super(MSG, thrwbl);
    }
    
}
