package ajs.parkinggarageapp;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 * Display window for Entering the parking garage.
 * Displays the ticket information such as the carID and date of access.
 * @author ajSchmidt-Zimmel
 * @version 1.2
 */
public class ParkingTerminalEnterDisplayWindow extends javax.swing.JFrame {
    private final OutputService receiptOutput;
//    private final JFrame prevWindow;
    private final OutputService salesOutput;
    private final FeeCalculator feeCalc;
    private final File file;
    private final CarCatalog carCat;
    private final JFrame garageWindow;
    private final ParkingTerminal terminal;
    private final Garage garageInfo;

    /**
     * Creates new form EnterDisplayWindow.
     * adjusts the text area to reflect the ticket
     * @param garageWindow
     * @param terminal
     * @param garageInfo
     * @param carID id of the new car
     * @param receiptOutput
     * @param salesOutput
     * @param fee
     * @param date date the car entered       //////////JFrame start,
     * @param carCat
     * @param file
     */
    public ParkingTerminalEnterDisplayWindow(JFrame garageWindow, ParkingTerminal terminal, Garage garageInfo, int carID, String date, OutputService receiptOutput, OutputService salesOutput, FeeCalculator fee, File file, CarCatalog carCat) {
//        this.prevWindow = start;    
        this.receiptOutput = receiptOutput;
        this.salesOutput = salesOutput;
        this.feeCalc = fee;
        this.file = file;
        this.carCat = carCat;
        initComponents();
        textArea.append("Car ID: " + carID + "\n");
        textArea.append("Date: " + date);
        this.garageWindow = garageWindow;
        this.terminal = terminal;
        this.garageInfo = garageInfo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textAreaPane = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        textArea.setColumns(20);
        textArea.setRows(5);
        textAreaPane.setViewportView(textArea);

        back.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        back.setText("Ok");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(textAreaPane, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(back)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(textAreaPane, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(back)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Returns user to previous frame.
     * Back to start window
     * @param evt 
     */
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        ParkingTerminalStartWindow prevWindow = null;
        try {
            prevWindow = new ParkingTerminalStartWindow(garageWindow, garageInfo, receiptOutput, terminal, salesOutput, feeCalc, file, carCat);
        } catch (IOException | NullOrEmptyArgumentException ex) {
            Logger.getLogger(ParkingTerminalEnterDisplayWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        prevWindow.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

  


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTextArea textArea;
    private javax.swing.JScrollPane textAreaPane;
    // End of variables declaration//GEN-END:variables
}