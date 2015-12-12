
package ajs.parkinggarageapp;

/**
 * Output class for netbeans console output.
 * Uses print line to print the string data to the console.
 * @author ajSchmidt-Zimmel
 */
public class ConsoleOutput implements OutputStrategy {
    
    /**
     * Prints to data to String data to the console.
     * @param data to be printed.
     * @throws NullOrEmptyArgumentException custom exception class for argument
     * passed to method that is null of empty, containing nothing.
     */
    @Override
    public final void outputData(String data) throws NullOrEmptyArgumentException{
        if(data == null || data.isEmpty()){
            throw new NullOrEmptyArgumentException("String cannot be null or empty, from outputData in ConsoleOutput.");
        }
        System.out.println(data);
    }
    
}
