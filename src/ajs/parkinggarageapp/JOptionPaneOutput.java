package ajs.parkinggarageapp;

import javax.swing.JOptionPane;

/**
 *
 * @author Alyson
 */
public class JOptionPaneOutput implements OutputStrategy{

    @Override
    public final void outputData(String data) {
        JOptionPane.showMessageDialog(null, data);
    }
    
}
