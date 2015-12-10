
package ajs.parkinggarageapp;

/**
 *
 * @author ajSchmidt-Zimmel
 */
public interface OutputStrategy {

    public abstract void outputData(String data) throws NullOrEmptyArgumentException;
    
}
