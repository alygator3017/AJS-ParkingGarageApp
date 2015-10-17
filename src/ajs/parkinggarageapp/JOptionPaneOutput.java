package ajs.parkinggarageapp;

import javax.swing.JOptionPane;

/**
 *
 * @author Alyson
 */
public class JOptionPaneOutput implements OutputStrategy{

    @Override
    public final void outputData(String data) throws IllegalArgumentException {
        if(data == null || data.isEmpty()){
            throw new IllegalArgumentException();
        }
        JOptionPane.showMessageDialog(null, data);
    }
    
}
