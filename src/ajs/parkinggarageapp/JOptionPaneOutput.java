package ajs.parkinggarageapp;

import javax.swing.JOptionPane;

/**
 * JOption Pane class that is part of the Output strategy. 
 * retrieves some data and outputs it to a JOptionPane.
 * @author ajSchmidt-Zimmel
 * @version 1.2
 */
public class JOptionPaneOutput implements OutputStrategy{

    /**
     * Outputs the data brought in to a JOptionPane.
     * 
     * @param data The data needing to be printed.
     * @throws NullOrEmptyArgumentException Custom Exception Class.
     */
    @Override
    public final void outputData(String data) throws NullOrEmptyArgumentException {
        if(data == null || data.isEmpty()){
            throw new NullOrEmptyArgumentException("data cannot be null or empty in outputData of JOptionPaneOutput.");
        }
        JOptionPane.showMessageDialog(null, data);
    }
    
}
