
package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class ConsoleOutput implements OutputStrategy {
    
    @Override
    public final void outputData(String data) throws IllegalArgumentException{
        if(data == null || data.isEmpty()){
            throw new IllegalArgumentException();
        }
        System.out.println(data);
    }
    
}
