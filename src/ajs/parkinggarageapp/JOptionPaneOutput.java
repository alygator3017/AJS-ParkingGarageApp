package ajs.parkinggarageapp;

import javax.swing.JOptionPane;

/**
 *
 * @author ajSchmidt-Zimmel
 */
public class JOptionPaneOutput implements OutputStrategy{

    @Override
    public final void outputData(String data) throws NullOrEmptyArgumentException {
        if(data == null || data.isEmpty()){
            throw new NullOrEmptyArgumentException();
        }
        JOptionPane.showMessageDialog(null, data);
    }
    
}
