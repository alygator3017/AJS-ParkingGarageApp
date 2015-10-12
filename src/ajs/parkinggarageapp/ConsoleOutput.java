
package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class ConsoleOutput implements OutputStrategy {
    
    @Override
    public void outputData(String data){
        System.out.println(data);
    }
    
}
