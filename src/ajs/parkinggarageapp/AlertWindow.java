package ajs.parkinggarageapp;

import javax.swing.JFrame;

/**
 * Used to Alerts from the GUI windows.
 * can be used for alert messages from the GUI frames. This will take
 * a message and the previous frame in order to accomplish.
 * @author Alyson
 * @version 1.2
 */
public class AlertWindow extends javax.swing.JFrame {
    private final JFrame prevWindow;
    private String msg;

    /**
     * Creates new form AlertWindow
     * 
     * @param prevWindow Previous window to go back to.
     * @param msg Message to be displayed.
     * @throws ajs.parkinggarageapp.NullOrEmptyArgumentException Custom exception class.
     */
    public AlertWindow(JFrame prevWindow, String msg) throws NullOrEmptyArgumentException {
        if(prevWindow == null || msg == null || msg.isEmpty()){
            throw new NullOrEmptyArgumentException("Argument cannot be null, from AlertWindow constructor.");
        }
        this.prevWindow = prevWindow;
        this.msg = msg;
        
        initComponents();
        textLabel.setText(this.msg);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Alert!");

        textLabel.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        textLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(171, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(164, 164, 164))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(textLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backButton)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Goes back to previous window.
     * @param evt 
     */
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        prevWindow.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel textLabel;
    // End of variables declaration//GEN-END:variables
}