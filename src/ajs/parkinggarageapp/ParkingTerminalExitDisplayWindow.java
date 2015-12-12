package ajs.parkinggarageapp;

/**
 * Exit terminals display window.
 * Displays the car information in order to exit the garage. Then calls to the 
 * terminal to actually perform the exit commands.
 * @author ajSchmidt-Zimmel
 * @version 1.2
 */
public class ParkingTerminalExitDisplayWindow extends javax.swing.JFrame {
 
    /**
     * Creates new form ParkingTerminalExitDisplayWindow
     * @param carID
     * @param sDate
     * @param fees
     * @param hours
     */
    public ParkingTerminalExitDisplayWindow(int carID, String sDate, Double fees, Double hours) {
        initComponents();
        titleLabel.setText("Thank you for parking with us!");
        carIDText.setText("Car no: " + carID);
        dateLabel.setText("Enter date: " + sDate);
        feesLabel.setText("Total fees: $" + fees);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        feesLabel = new javax.swing.JLabel();
        carIDText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        dateLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        feesLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        feesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        carIDText.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        carIDText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carIDText, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(feesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(carIDText, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(feesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel carIDText;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel feesLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}