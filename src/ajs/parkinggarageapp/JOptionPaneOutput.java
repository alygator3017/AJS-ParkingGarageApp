/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajs.parkinggarageapp;

import javax.swing.JOptionPane;

/**
 *
 * @author Alyson
 */
public class JOptionPaneOutput implements OutputStrategy{

    @Override
    public void outputData(String data) {
        JOptionPane.showMessageDialog(null, data);
    }
    
}
