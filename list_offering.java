/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package offerings_reservation;

/**
 *
 * @author elhaizamae
 */
import offerings_reservation.list_offering;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import reservation.reservations;


public class list_offering extends javax.swing.JFrame {

    private JTable table;    
    private String uemail;
    private String uage;
    private String ugender;
   
    /**
     * Creates new form list_offering
     */
    public list_offering() {
        initComponents();
        populateTable();
    
    }
    
    public void setName(String name) {
        txtCNAME.setText(name); // Set the client's name in the text field
    }
    public void setEmail(String email){
        this.uemail = email;
    }
    public void setAge(String age){
        this.uage = age;
    }
    public void setGender(String gender){
        this.ugender = gender;
    }
    
     private Connection connectToDB() {
        try {
            String url = "jdbc:mysql://localhost:3306/databaseresort";
            String user = "root";
            String password = "";
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to populate the JTable with data from the database
    private void populateTable() {
    try {
        Connection conn = connectToDB();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM solace_offerings");

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Select");
        model.addColumn("ID");
        model.addColumn("Type");
        model.addColumn("Name");
        model.addColumn("Price");
        model.addColumn("Remarks");
        model.addColumn("Category");

        while (rs.next()) {
            Object[] row = new Object[7];
            row[0] = false;  // checkbox column
            row[1] = rs.getInt("id");
            row[2] = rs.getString("type");
            row[3] = rs.getString("name");
            row[4] = rs.getInt("price");
            row[5] = rs.getString("remarks");
            row[6] = rs.getString("category");
            model.addRow(row);
        }

        table = new JTable(model) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Boolean.class;  // checkbox column
                }
                return super.getColumnClass(columnIndex);
            }
        };

        // Set checkbox editor
        table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));

        table.setPreferredScrollableViewportSize(new java.awt.Dimension(600, 300));
        
        // Ensure that jScrollPane1 is initialized before setting the table
        if (jScrollPane1 != null) {
            jScrollPane1.setViewportView(table);
            jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        }

        conn.close();
    } catch (SQLException e) {
        System.out.println("Error populating table: " + e.getMessage());
    }
}


 private void getSelectedItems() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        List<String> selectedItems = new ArrayList<>();

        for (int i = 0; i < model.getRowCount(); i++) {
            Boolean isSelected = (Boolean) model.getValueAt(i, 0);  // checkbox column
            if (isSelected != null && isSelected) {
                int id = (Integer) model.getValueAt(i, 1);      // Get ID column
                String type = (String) model.getValueAt(i, 2);   // Get Type column
                String name = (String) model.getValueAt(i, 3);   // Get Name column
                int price = (Integer) model.getValueAt(i, 4);    // Get Price column
                String remarks = (String) model.getValueAt(i, 5); // Get Remarks column
                String category = (String) model.getValueAt(i, 6); // Get Category column

                // Format the selected items in a readable format
                selectedItems.add(String.format("ID: %d, Type: %s, Name: %s, Price: %d, Remarks: %s, Category: %s", 
                        id, type, name, price, remarks, category));
            }
        }

        if (!selectedItems.isEmpty()) {
            StringBuilder selectedItemsMessage = new StringBuilder("You have selected the following items:\n");
            for (String item : selectedItems) {
                selectedItemsMessage.append(item).append("\n");
            }

            JOptionPane.showMessageDialog(this, selectedItemsMessage.toString(), "Reservation Confirmation", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No items selected. Please select items to reserve.", 
                                          "No Selection", JOptionPane.WARNING_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnCONFIRM = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtCNAME = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 51, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CLIENTS RESERVATION");

        btnCONFIRM.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCONFIRM.setText("CONFIRMATION");
        btnCONFIRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCONFIRMActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("NAME : ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 563, Short.MAX_VALUE)
                        .addComponent(btnCONFIRM, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnCONFIRM, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 140));

        jPanel2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel2AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(570, 570, 570))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(610, 610, 610)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(629, 629, 629)
                        .addComponent(jLabel3)))
                .addContainerGap(694, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(474, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGap(67, 67, 67))
        );

        jScrollPane1.setViewportView(jPanel2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1354, 574));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCONFIRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCONFIRMActionPerformed
        String clientName = txtCNAME.getText().trim(); // Get the client's name from the text field
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    boolean anySelected = false;

    // Establish database connection
    Connection con = null;
    PreparedStatement ps = null;

    try {
        con = connectToDB(); // Connect to the database

        // Prepare the SQL statement for inserting into selectedOffers
        String insertQuery = "INSERT INTO selectedoffers (clientName, types, offers, price) VALUES (?, ?, ?, ?)";
        ps = con.prepareStatement(insertQuery);

        // StringBuilder to hold selected items for the reservations frame
        StringBuilder selectedItems = new StringBuilder();

        for (int i = 0; i < model.getRowCount(); i++) {
            Boolean isSelected = (Boolean) model.getValueAt(i, 0);  // Get value of checkbox column
            if (isSelected != null && isSelected) {
                String type = (String) model.getValueAt(i, 2);   // Get Type column
                String name = (String) model.getValueAt(i, 3);   // Get Name column
                int price = (Integer) model.getValueAt(i, 4);    // Get Price column
                String remarks = (String) model.getValueAt(i, 5); // Get Remarks column
                String category = (String) model.getValueAt(i, 6); // Get Category column
                int id = (Integer) model.getValueAt(i, 1); // Get ID column

                // Set parameters for the prepared statement
                ps.setString(1, clientName);
                ps.setString(2, type);
                ps.setString(3, name);
                ps.setInt(4, price);

                // Execute the insert statement
                ps.executeUpdate();
                anySelected = true; // Mark that at least one item was selected
                
                // Append selected item details for the reservations frame
                selectedItems.append(String.format("%d, %s, %s, %d, %s, %s\n", id, type, name, price, remarks, category));
            }
        }

        if (anySelected) {
            // Show the reservations frame with selected items
            reservations rs = new reservations(selectedItems.toString(), clientName);
            rs.setVisible(true);
            this.dispose(); // Close the current frame
        } else {
            JOptionPane.showMessageDialog(this, "No items selected. Please select items to reserve.", "No Selection", JOptionPane.WARNING_MESSAGE);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "An error occurred while saving data: " + e.getMessage());
    } finally {
        // Close resources
        try {
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

       
       /*
        StringBuilder selectedItems = new StringBuilder();
    
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    
    // Loop through the table rows and check which items are selected
    for (int i = 0; i < model.getRowCount(); i++) {
        Boolean isSelected = (Boolean) model.getValueAt(i, 0);  // Check if item is selected
        if (isSelected != null && isSelected) {
            String name = (String) model.getValueAt(i, 3);  // Get Name
            selectedItems.append(name).append("\n");
        }
    }

    // If there are selected items, show the message, else show an error message
    if (selectedItems.length() > 0) {
        // Show the selected items in the JOptionPane
        JOptionPane.showMessageDialog(this, "Successfully reserved:\n" + selectedItems.toString(), 
                                      "Reservation Confirmation", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "No items selected. Please select items to reserve.", 
                                      "No Selection", JOptionPane.WARNING_MESSAGE);
    }
       */
    }//GEN-LAST:event_btnCONFIRMActionPerformed

    private void jPanel2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel2AncestorAdded
         populateTable(); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2AncestorAdded

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
            java.util.logging.Logger.getLogger(list_offering.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(list_offering.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(list_offering.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(list_offering.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new list_offering().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCONFIRM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCNAME;
    // End of variables declaration//GEN-END:variables
}
