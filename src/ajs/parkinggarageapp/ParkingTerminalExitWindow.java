/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajs.parkinggarageapp;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import utilities.DateUtilities;

/**
 *
 * @author Alyson
 */
public class ParkingTerminalExitWindow extends javax.swing.JFrame {
    private final OutputService receiptOutput;
    private final OutputService salesReportOutput;
    private final JFrame garageWindow;
    private final Garage garageInfo;
    private final ParkingTerminal terminal;
    private final FeeCalculator feeCalculator;
    private final File file;
    private final int selectedID;
    private final CarCatalog carCat;
    private ErrorWindow error = null;
    private ParkingTerminalStartWindow start = null;

    /**
     * Creates new form ExitParkingTerminalWindow
     * @param garageWindow
     * @param garageInfo
     * @param feeCalculator
     * @param file
     * @param receiptOutput
     * @param terminal
     * @param salesReportOutput
     * @param selectedID
     * @param carCat
     */
    public ParkingTerminalExitWindow(JFrame garageWindow, Garage garageInfo, ParkingTerminal terminal, 
            OutputService receiptOutput, OutputService salesReportOutput, FeeCalculator feeCalculator, 
            File file, int selectedID, CarCatalog carCat ) {
        initComponents();
        this.receiptOutput = receiptOutput;
        this.salesReportOutput = salesReportOutput;
        this.garageWindow = garageWindow;
        this.garageInfo = garageInfo;
        this.terminal = terminal;
        this.feeCalculator = feeCalculator;
        this.file = file;
        this.selectedID = selectedID;
        this.carCat = carCat;
        garageNameDisplay.setText(garageInfo.getName());
        ticketIDDisplay.setText("Car ID: " + selectedID);
        DateUtilities dateUtilities = new DateUtilities();
        ticketDateDisplay.setText(dateUtilities.toString(carCat.getDateOfCar(selectedID), DateTimeFormatter.ofPattern("MM-dd-YYYY hh:mm a")));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exitGarage = new javax.swing.JButton();
        back = new javax.swing.JButton();
        ticketIDDisplay = new javax.swing.JLabel();
        ticketDateDisplay = new javax.swing.JLabel();
        garageNameDisplay = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        exitGarage.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        exitGarage.setText("Exit Garage");
        exitGarage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitGarageActionPerformed(evt);
            }
        });

        back.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        ticketIDDisplay.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        ticketIDDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        ticketDateDisplay.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        ticketDateDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        garageNameDisplay.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        garageNameDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(exitGarage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(back))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ticketIDDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ticketDateDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(garageNameDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(ticketIDDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(ticketDateDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(exitGarage)
                    .addComponent(back))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(garageNameDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(222, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitGarageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitGarageActionPerformed
        try {
                terminal.exitParkingGarage(selectedID);
            } catch (NullOrEmptyArgumentException ex) {
               error = new ErrorWindow(this, "Id is invalid: " + ex);
            }
        carCat.getCarList().remove(selectedID);
        try {
            start = new ParkingTerminalStartWindow(garageWindow, garageInfo, receiptOutput,
                    salesReportOutput, feeCalculator, file, carCat);
        } catch (IOException ex) {
            error = new ErrorWindow(this, "problem getting back to start window: " + ex);
        } catch (NullOrEmptyArgumentException ex) {
            error = new ErrorWindow(this, "problem getting back to start window: " + ex);
        }
    }//GEN-LAST:event_exitGarageActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        try {
            start = new ParkingTerminalStartWindow(garageWindow, garageInfo, 
                    receiptOutput, salesReportOutput, feeCalculator, file, carCat);
        } catch (IOException ex) {
            error = new ErrorWindow(this, "problem getting back to start window: " + ex);
            error.setVisible(true);
            this.setVisible(false);
        } catch (NullOrEmptyArgumentException ex) {
            error = new ErrorWindow(this, "problem getting back to start window: " + ex);
        }
        start.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton exitGarage;
    private javax.swing.JLabel garageNameDisplay;
    private javax.swing.JLabel ticketDateDisplay;
    private javax.swing.JLabel ticketIDDisplay;
    // End of variables declaration//GEN-END:variables
}
