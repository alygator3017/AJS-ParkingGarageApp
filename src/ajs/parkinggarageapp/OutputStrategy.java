
package ajs.parkinggarageapp;

/**
 * Output strategy interface.
 * See Output Service or various output classes.
 * @author ajSchmidt-Zimmel
 * @version 1.2
 */
public interface OutputStrategy {

    public abstract void outputData(String data) throws NullOrEmptyArgumentException;
    
}
