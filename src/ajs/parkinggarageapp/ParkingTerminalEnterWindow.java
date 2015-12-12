package ajs.parkinggarageapp;

import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;

/**
 * The parking terminal ticket dispenser enter GUI screen.
 * Allows the user to press the button in order to create a new ticket.
 * @author ajSchmidt-Zimmel
 * @version 1.2
 */
public class ParkingTerminalEnterWindow extends javax.swing.JFrame {

    private final JFrame garageWindow;
    private final Garage garageInfo;
    private final ParkingTerminal terminal;
    private final OutputService errorOutput;
    private final CarCatalog carCatalog;
    private final OutputService salesROutput;
    private final FeeCalculator feeCalculator;
    private final File file;

    /**
     * Creates new form EnterParkingTerminalForm
     *
     * @param garage
     * @param garageInfo
     * @param terminal
     * @param receiptOutput
     * @param salesOutput
     * @param fee
     * @param file
     * @param carCatalog
     */
    public ParkingTerminalEnterWindow(JFrame garage, Garage garageInfo, ParkingTerminal terminal, OutputService receiptOutput, OutputService salesOutput, FeeCalculator fee, File file, CarCatalog carCatalog) {
        this.garageWindow = garage;
        initComponents();
        this.garageInfo = garageInfo;
        this.terminal = terminal;
        this.errorOutput = receiptOutput;
        this.salesROutput = salesOutput;
        this.feeCalculator = fee;
        this.file = file;
        this.carCatalog = carCatalog;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newTicket = new javax.swing.JButton();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        newTicket.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        newTicket.setText("Press For Ticket");
        newTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTicketActionPerformed(evt);
            }
        });

        back.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        back.setText("Back");
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
                .addContainerGap(110, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(newTicket)
                        .addGap(107, 107, 107))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(back)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(newTicket)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(back)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Creates a new ticket, sends user to display window. The display window
     * user is sent to then displays ticket information.
     *
     * @param evt
     */
    private void newTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTicketActionPerformed
        ParkingAccessTicket ticket = null;
        try {
            ticket = terminal.newParkingTicket();
        } catch (NullOrEmptyArgumentException ex) {
            
            //endless try catch problems here.
            System.out.println(ex);
        }
        ParkingTerminalEnterDisplayWindow display = new ParkingTerminalEnterDisplayWindow(garageWindow , terminal,  garageInfo, ticket.getCarID(), ticket.getDateOfAccess().toString(), errorOutput, salesROutput, feeCalculator, file, carCatalog);
        display.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_newTicketActionPerformed

    /**
     * DONT KNOW IF THIS IS GOING TO WORK RIGHT NOW< TRYING TO GET SALES REPORT TO PRINT CORRECTLY BY GOING BACK TO START WITHOUT RESETING IT.
     * @param evt 
     */
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        ParkingTerminalStartWindow start = null;
        try {
            start = new ParkingTerminalStartWindow(garageWindow, garageInfo, errorOutput, terminal, salesROutput,
                    feeCalculator, file, carCatalog);
        } catch (IOException | NullOrEmptyArgumentException ex) {
            System.out.println(ex.getMessage() + "problem in backActionPerformed in PT enter window.");
        }
        //THIS IS A PART I"M NOT SURE WILL ACTUALLY WORK UNTIL TESTED
        start.resetCarCatalogComboBox();
        start.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton newTicket;
    // End of variables declaration//GEN-END:variables
}
