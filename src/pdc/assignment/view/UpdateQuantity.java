/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pdc.assignment.view;

import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import pdc.assignment.model.Items;
import pdc.assignment.model.Locations;
import pdc.assignment.model.Transfer;
import pdc.assignment.pkg2.HibernateUtil;
import pdc.assignment.services.ItemInterface;
import pdc.assignment.services.ItemManagement;
import pdc.assignment.services.LocationInterface;
import pdc.assignment.services.LocationManagement;
import pdc.assignment.services.TransferInterface;
import pdc.assignment.services.TransferManagement;

/**
 *
 * @author kmann
 */
public class UpdateQuantity extends javax.swing.JPanel {
    private final Locations location;
    private JFrame parentFrame;
    /**
     * Creates new form UpdateQuantity
     */
    public UpdateQuantity(Locations location, JFrame parentFrame) {
        this.location = location;
        this.parentFrame = parentFrame;
        initComponents();
        
        parentFrame.setMinimumSize(new Dimension(850, 690));
        // Add a ComponentListener to limit resizing
        parentFrame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = parentFrame.getWidth();
                int height = parentFrame.getHeight();
                if (width < 850 || height < 690) {
                    parentFrame.setSize(Math.max(width, 850), Math.max(height, 690));
                }
            }
        });
        loadItems();
    }

     //populate removeItemsDropdown
     private void loadItems() {
         ItemInterface it = new ItemManagement();
        List<Items> items = it.browseItemsByLocation(location);
        if (items != null) {
            for (Items item : items) {
                updateQuantityItem.addItem(item.getName());
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

        updateQuantityNameLabel = new javax.swing.JLabel();
        updateQuantityItem = new javax.swing.JComboBox<>();
        updateQuantityBoxLabel = new javax.swing.JLabel();
        updateQuantityBox = new javax.swing.JTextField();
        updateQuantityBack = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        updateQuantityConfirm = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        updateQuantityNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        updateQuantityNameLabel.setText("Select which item:");

        updateQuantityItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateQuantityItemActionPerformed(evt);
            }
        });

        updateQuantityBoxLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        updateQuantityBoxLabel.setText("Update this item's quantity:");

        updateQuantityBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateQuantityBoxActionPerformed(evt);
            }
        });

        updateQuantityBack.setText("Go back");
        updateQuantityBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateQuantityBackActionPerformed(evt);
            }
        });

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        updateQuantityConfirm.setText("Confirm");
        updateQuantityConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateQuantityConfirmActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Update an item's quantity");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(169, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(exit)
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(updateQuantityBack)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(updateQuantityConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(updateQuantityNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(updateQuantityBoxLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(49, 49, 49)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(updateQuantityBox, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(updateQuantityItem, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel1))
                        .addContainerGap(174, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel1)
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateQuantityNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateQuantityItem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateQuantityBoxLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateQuantityBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateQuantityConfirm)
                    .addComponent(updateQuantityBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                .addComponent(exit)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateQuantityBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateQuantityBoxActionPerformed
        // TODO add your handling code here: text box
    }//GEN-LAST:event_updateQuantityBoxActionPerformed

    private void updateQuantityItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateQuantityItemActionPerformed
        // TODO add your handling code here: drop down menu
    }//GEN-LAST:event_updateQuantityItemActionPerformed

    private void updateQuantityBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateQuantityBackActionPerformed
        // TODO add your handling code here:

        JFrame itemPanelFrame = new JFrame("Item Panel");
        itemPanelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        itemPanelFrame.setSize(850, 690);
        itemPanelFrame.add(new ItemPanel(location,itemPanelFrame));
        itemPanelFrame.setLocationRelativeTo(null); //center the frame
        itemPanelFrame.setVisible(true);

        parentFrame.dispose(); //close panel
    }//GEN-LAST:event_updateQuantityBackActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        int confirmed = JOptionPane.showConfirmDialog(null,
            "Are you sure you want to exit the program?", "Exit Program",
            JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
            //perform any cleanup or saving operations if needed

            //close the main window or exit the application
            Window window = SwingUtilities.getWindowAncestor(this);
            window.dispose(); //closes
            HibernateUtil.shutdown();
            System.exit(0);
        }
    }//GEN-LAST:event_exitActionPerformed

    private void updateQuantityConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateQuantityConfirmActionPerformed
        // TODO add your handling code here:
        if (isValidInput()) {
            try {
                String itemName = (String) updateQuantityItem.getSelectedItem();
                ItemInterface it = new ItemManagement();
                Items item = it.itemLoad(itemName, location);

                // Convert quantity input to integer
                int newQuantity = Integer.parseInt(updateQuantityBox.getText());

                boolean updated = it.updateQuantity(item, newQuantity);

                if (updated) {
                    JOptionPane.showMessageDialog(this, "Item updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update item.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                // Handle the case where quantity input is not a valid integer
                JOptionPane.showMessageDialog(this, "Invalid quantity input. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid input, try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_updateQuantityConfirmActionPerformed
                                                  

    private boolean isValidInput() {
        return !updateQuantityBox.getText().isEmpty();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton updateQuantityBack;
    private javax.swing.JTextField updateQuantityBox;
    private javax.swing.JLabel updateQuantityBoxLabel;
    private javax.swing.JButton updateQuantityConfirm;
    private javax.swing.JComboBox<String> updateQuantityItem;
    private javax.swing.JLabel updateQuantityNameLabel;
    // End of variables declaration//GEN-END:variables
}
