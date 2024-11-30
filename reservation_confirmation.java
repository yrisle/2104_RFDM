/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package reservation;
import offerings_reservation.list_offering;
/**
 *THIS CODE NO LONGER USED
 * 
 * @author elhaizamae
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


//txtArea.setText("Successfully Reserved:\n" + selectedItems);

public class reservation_confirmation extends javax.swing.JFrame {
    private JTable table; 
    private JLabel reservedLabel;
       private javax.swing.JTable reservedItemsTable;
    private javax.swing.JScrollPane jScrollPane2;
    private int tableHeight;


    /**
     * Creates new form reservation_confirmation
     */
  // Declare JTable for displaying the selected items

    // Constructor that takes the selected items (as a string)
    ///////////////////////////////////////////////////////////////////////////////////////////////
    public reservation_confirmation(String selectedItems, String clientName) {
        initComponents();
        
        txtCname.setText(clientName);
        
     java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;
    
    // Set the window size to full screen width and adjusted height
    setSize(screenWidth, screenHeight - 100); // Subtract 100 for some padding from the top


        // Parse the selected items string into rows and columns
        String[] rows = selectedItems.split("\n"); // Split by line breaks (each row of data)
        String[][] data = new String[rows.length][6]; // Six columns: Name, ID, Type, Price, Remarks, Category
        
        // Loop through each row and extract data (Name, ID, Type, Price, Remarks, Category)
        for (int i = 0; i < rows.length; i++) {
            // Skip any empty lines that may exist
            if (rows[i].trim().isEmpty()) {
                continue;
            }

            String[] columns = rows[i].split(" - ");  // Split by " - " (separator between Name and other data)
            if (columns.length < 2) {
                // If the split does not result in 2 parts, skip the row
                continue;
            }

            String[] details = columns[0].split("\\(ID: "); // Split Name and ID
            if (details.length < 2) {
                // If the details split doesn't result in 2 parts, skip this row
                continue;
            }

            String name = details[0].trim(); // Extract Name
            String id = details[1].replace(")", "").trim(); // Extract ID

            String type = "";
            String price = "";
            String remarks = "";
            String category = "";

            if (columns.length > 1) {
                // Process the second part after the first split
                String[] infoColumns = columns[1].split(","); // Split by commas to get Type, Price, Remarks, and Category
                for (String info : infoColumns) {
                    if (info.contains("Type:")) {
                        type = info.split(":")[1].trim();
                    } else if (info.contains("Price:")) {
                        price = info.split(":")[1].trim();
                    } else if (info.contains("Remarks:")) {
                        remarks = info.split(":")[1].trim();
                    } else if (info.contains("Category:")) {
                        category = info.split(":")[1].trim();
                    }
                }
            }

            // Fill in the row data
            data[i][0] = name;  // Set Name
            data[i][1] = id;    // Set ID
            data[i][2] = type;  // Set Type
            data[i][3] = price; // Set Price
            data[i][4] = remarks; // Set Remarks
            data[i][5] = category; // Set Category
        }

        // Create column names for the table
        String[] columnNames = { "Name", "ID", "Type", "Price", "Remarks", "Category" };

        // Create a table model and set the data
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
    table = new JTable(model);
    jScrollPane2 = new JScrollPane(table);
    
    // Set the height of the scroll pane to 250 pixels
    int tableHeight = 250; // Fixed height for the table
    jScrollPane2.setBounds(0, 0, screenWidth, tableHeight);  // Set bounds to fill the width of the screen

    // Add the JScrollPane to the panel
    jPanel1.setLayout(null); // Use null layout to manually position components
    jPanel1.add(jScrollPane2);

    // Set the window properties (Full width, fixed height)
    setTitle("Reservation Confirmation");
    setSize(screenWidth, tableHeight + 150); // Full width and height based on content
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);
    }

    // Constructor to accept selected items string
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtCname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(1366, 768));
        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 768));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1501, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 168, 1501, 280));

        jPanel2.setBackground(new java.awt.Color(102, 51, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CLIENTS CONFIRMATION");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inquiry_info/logo-removebg-preview__1_-removebg-preview.png"))); // NOI18N

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setText("RESERVED");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NAME : ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCname, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 514, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(403, 403, 403))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(369, 369, 369))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 566, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, 1000));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(reservation_confirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reservation_confirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reservation_confirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reservation_confirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
           try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reservation_confirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String selectedItems = "";
            }
               
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCname;
    // End of variables declaration//GEN-END:variables
}
