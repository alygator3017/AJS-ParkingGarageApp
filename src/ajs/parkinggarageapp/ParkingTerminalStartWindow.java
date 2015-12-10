package ajs.parkinggarageapp;

import fileserviceapp.FileService;
import fileserviceapp.GarageTotalsFormatter;
import fileserviceapp.TextFormatStrategy;
import fileserviceapp.TextReader;
import fileserviceapp.TextWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Alyson
 */
public class ParkingTerminalStartWindow extends javax.swing.JFrame {

    private final JFrame garageWindow;
    private final Garage garageInfo;
    private final File file;
    private final OutputService receiptOutput;
    private final OutputService salesReportOutput;
    private final FeeCalculator feeCalculator;
    private final ParkingTerminal terminal;
    private final CarCatalog carCatalog;
    private final Vector<Integer> carIDs = new Vector<>();

    /**
     * Creates new form ParkingTerminalStartForm
     *
     * @param garageWindow
     * @param garageInfo
     * @param receiptOutput
     * @param salesReportOutput
     * @param feeCalc
     * @param file
     * @param carCatalog
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws ajs.parkinggarageapp.NullOrEmptyArgumentException
     */
    public ParkingTerminalStartWindow(JFrame garageWindow,
            Garage garageInfo, OutputService receiptOutput, OutputService salesReportOutput, FeeCalculator feeCalc, File file, CarCatalog carCatalog) throws IOException, FileNotFoundException, NullOrEmptyArgumentException {
        this.garageWindow = garageWindow;
        this.carCatalog = carCatalog;
        Set<Integer> keys = carCatalog.getCarList().keySet();
        if (keys.size() <= 0) {
            carIDs.add(0);
        } else {
            carIDs.clear();
            for (Integer k : keys) {
                carIDs.add(k);
            }
        }
        initComponents();
        this.garageInfo = garageInfo;
        this.file = file;
        this.receiptOutput = receiptOutput;
        this.salesReportOutput = salesReportOutput;
        this.feeCalculator = feeCalc;
        TextFormatStrategy format = new GarageTotalsFormatter();
        FileService fs = new FileService(new TextReader(format), new TextWriter(format));

        this.terminal = new ParkingTerminal(receiptOutput, receiptOutput, salesReportOutput, garageInfo, feeCalculator, fs, file, carCatalog);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new javax.swing.JButton();
        dispenserTerminalButton = new javax.swing.JButton();
        exitTerminalButton = new javax.swing.JButton();
        carIdComboBox = new javax.swing.JComboBox(carIDs);
        carIDLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        backButton.setText("Back to Garage Owner Page");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        dispenserTerminalButton.setText("Check In New Car");
        dispenserTerminalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispenserTerminalButtonActionPerformed(evt);
            }
        });

        exitTerminalButton.setText("Check Out Car");
        exitTerminalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitTerminalButtonActionPerformed(evt);
            }
        });

        carIDLabel.setText("Car To Check Out: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(dispenserTerminalButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitTerminalButton)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(carIDLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(carIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(backButton)
                .addContainerGap(153, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carIDLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitTerminalButton)
                    .addComponent(dispenserTerminalButton))
                .addGap(56, 56, 56)
                .addComponent(backButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * To Exit Terminal Window Button. Takes user to Exit terminal after having
     * chosen a car to check out.
     *
     * @param evt
     */
    private void exitTerminalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitTerminalButtonActionPerformed
        int selected = Integer.parseInt(carIdComboBox.getSelectedItem().toString());
//        System.out.println(selected);
        ErrorWindow error = null;
        if (selected == 0) {

            error = new ErrorWindow(this, "No Cars Are In The Garage entered");
            error.setVisible(true);
            this.setVisible(false);

        } else {
            int id = selected;
            
            ParkingTerminalExitWindow exit = new ParkingTerminalExitWindow(garageWindow, garageInfo, 
                    terminal, receiptOutput, salesReportOutput, feeCalculator, file, selected, carCatalog);
            
            exit.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_exitTerminalButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        garageWindow.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void dispenserTerminalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dispenserTerminalButtonActionPerformed
        ParkingTerminalEnterWindow enter = new ParkingTerminalEnterWindow(garageWindow, garageInfo, 
                terminal, receiptOutput, salesReportOutput, feeCalculator, file, carCatalog);
        enter.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_dispenserTerminalButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel carIDLabel;
    private javax.swing.JComboBox carIdComboBox;
    private javax.swing.JButton dispenserTerminalButton;
    private javax.swing.JButton exitTerminalButton;
    // End of variables declaration//GEN-END:variables
}
