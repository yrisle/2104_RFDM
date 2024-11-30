/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package reservation;

import javax.swing.table.DefaultTableModel;
import payment.payment_page;
/**
 *
 * @author elhaizamae
 */
public class reservations extends javax.swing.JFrame {

    /**
     * Creates new form reservations
     */
    public reservations(String selectedItems, String clientName) {
        initComponents();
        txtCname.setText(clientName); 

       
        String[] items = selectedItems.split("\n");
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        
        model.setRowCount(0);

        for (String item : items) {
            if (!item.trim().isEmpty()) {
                
                String[] details = item.split(", ");
                int id = Integer.parseInt(details[0].trim()); 
                String type = details[1].trim(); 
                String name = details[2].trim(); 
                int price = Integer.parseInt(details[3].trim()); 
                String remarks = details[4].trim(); 
                String category = details[5].trim(); 
                
 
                model.addRow(new Object[]{id, type, name, price, remarks, category});
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtCname = new javax.swing.JTextField();
        continuePaym = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(102, 51, 0));
        setMaximumSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "TYPE", "NAME", "PRICE", "REMARKS", "CATEGORIES"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 1205, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CLIENT ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        txtCname.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        getContentPane().add(txtCname, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 400, -1));

        continuePaym.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        continuePaym.setText("Continue to Payment");
        continuePaym.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuePaymActionPerformed(evt);
            }
        });
        getContentPane().add(continuePaym, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 610, 280, 60));

        jLabel2.setBackground(new java.awt.Color(102, 51, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/solace/Images/bg color.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -4, 1370, 770));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void continuePaymActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuePaymActionPerformed
        // TODO add your handling code here:
     
    double totalPayment = 0.0;
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

   
    for (int i = 0; i < model.getRowCount(); i++) {
        totalPayment += ((Number) model.getValueAt(i, 3)).doubleValue();
 
    }

   
    String clientName = txtCname.getText();

   
    payment_page pay = new payment_page(totalPayment, clientName);
    pay.setVisible(true);
    this.dispose(); 

    }//GEN-LAST:event_continuePaymActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(reservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reservations("", "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton continuePaym;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCname;
    // End of variables declaration//GEN-END:variables
}