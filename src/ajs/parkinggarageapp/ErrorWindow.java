package ajs.parkinggarageapp;

import javax.swing.JFrame;

/**
 * Error alert window for GUI.
 * When provided with the previous frame and a message, this window
 * will give an Error alert window and then take user back to previous frame.
 * @author Alyson
 */
public class ErrorWindow extends javax.swing.JFrame {
    private final JFrame previousWindow;
    

    /**
     * Creates new form ErrorWindow
     * @param prevWindow The previous frame to go back to.
     * @param msg Message for the error.
     * @throws ajs.parkinggarageapp.NullOrEmptyArgumentException
     */
    public ErrorWindow(JFrame prevWindow, String msg) throws NullOrEmptyArgumentException {
        if(prevWindow == null){
            throw new NullOrEmptyArgumentException("prevWindow is null in ErrorWindow constructor");
        }else if(msg == null){
            throw new NullOrEmptyArgumentException("msg is null in ErrorWindow constructor");
        }
        this.previousWindow = prevWindow;
        initComponents();
        message.setText(msg);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        message = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Error");

        message.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        message.setText("Error");

        okButton.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        label.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        label.setForeground(new java.awt.Color(204, 0, 0));
        label.setText("Error!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addComponent(label))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(191, 191, 191)
                                .addComponent(okButton)))
                        .addGap(0, 158, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(message)
                .addGap(18, 18, 18)
                .addComponent(okButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Sends user back to previous window
     * @param evt 
     */
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        previousWindow.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel label;
    private javax.swing.JLabel message;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}
