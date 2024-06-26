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
 * @author klinsmann
 */
public class TransferItem extends javax.swing.JPanel {

    private final Locations location;
    private JFrame parentFrame;

    /**
     * Creates new form TransferItem
     */
    public TransferItem(Locations location, JFrame parentFrame) {
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
        loadLocations();
    }
    
    //populate transferItemsDropdown
    private void loadItems() {
        ItemInterface it = new ItemManagement();
        List<Items> items = it.browseItemsByLocation(location);
        if (items != null) {
            for (Items item : items) {
                transferItemDropdown.addItem(item.getName());
            }
        }
    }
    
    //populate transferLocationDropdown
    private void loadLocations() {
        LocationInterface loc = new LocationManagement();
        List<Locations> locations = loc.browseLocations();
        if (locations != null) {
            for (Locations location : locations) {
                transferLocationDropdown.addItem(location.getName());
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

        transferItemDropdown = new javax.swing.JComboBox<>();
        jlabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        transferLocationDropdown = new javax.swing.JComboBox<>();
        transferItemBack = new javax.swing.JButton();
        confirmTransferItem = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        transferQuantity = new javax.swing.JTextField();

        jlabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlabel1.setText("Select an item to transfer:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Select a location to transfer to:");

        transferItemBack.setText("Go back");
        transferItemBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferItemBackActionPerformed(evt);
            }
        });

        confirmTransferItem.setText("Confirm");
        confirmTransferItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmTransferItemActionPerformed(evt);
            }
        });

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Item to Location Transferring");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Quantity of this item to transfer:");

        transferQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferQuantityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(177, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(exit)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(transferLocationDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(transferItemBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(confirmTransferItem))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jlabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(transferQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(transferItemDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(171, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel3)
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel1)
                    .addComponent(transferItemDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(transferQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(transferLocationDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(138, 138, 138)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transferItemBack)
                    .addComponent(confirmTransferItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(exit)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void transferItemBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferItemBackActionPerformed
        // TODO add your handling code here:

        JFrame itemPanelFrame = new JFrame("Item Panel");
        itemPanelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        itemPanelFrame.setSize(850, 690);
        itemPanelFrame.add(new ItemPanel(location, itemPanelFrame));
        itemPanelFrame.setLocationRelativeTo(null); //center the frame
        itemPanelFrame.setVisible(true);

        parentFrame.dispose(); //close panel
    }//GEN-LAST:event_transferItemBackActionPerformed

    private void confirmTransferItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmTransferItemActionPerformed
        // TODO add your handling code here:
        if (isValidInput()) {
            String itemName = (String) transferItemDropdown.getSelectedItem();
            if(itemName != null){
            String loadLocation = (String) transferLocationDropdown.getSelectedItem();
            LocationInterface loc = new LocationManagement();
            Locations destLocation = loc.loadLocation(loadLocation);

            if (!destLocation.equals(location)) {
                ItemInterface it = new ItemManagement();
                Items transferItem = it.itemLoad(itemName, location);
                TransferInterface ti = new TransferManagement();
                Transfer tran = new Transfer();
                try {
                    tran.setQuantity(Integer.parseInt(transferQuantity.getText()));
                    if (transferItem.getQuantity() - tran.getQuantity() >= 0) {
                        tran.setSourceLocation(location);
                        tran.setItem(transferItem);
                        tran.setDestLocation(destLocation);

                        boolean transferred = ti.transferItem(tran);

                        if (transferred) {
                            JOptionPane.showMessageDialog(this, "Item transferred successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(this, "Failed to transfer item.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid input: Not enough quantity to transfer.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input: Quantity must be a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid input: Cannot transfer to the location you are already in.", "Error", JOptionPane.ERROR_MESSAGE);                
            }
            }else{
                JOptionPane.showMessageDialog(this, "Invalid input: Please pick an item to transfer", "Error", JOptionPane.ERROR_MESSAGE);                                
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid input: Please check your inputs and try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_confirmTransferItemActionPerformed

    private boolean isValidInput() {
        return !transferQuantity.getText().isEmpty();
                }

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

    private void transferQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transferQuantityActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmTransferItem;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jlabel1;
    private javax.swing.JButton transferItemBack;
    private javax.swing.JComboBox<String> transferItemDropdown;
    private javax.swing.JComboBox<String> transferLocationDropdown;
    private javax.swing.JTextField transferQuantity;
    // End of variables declaration//GEN-END:variables
}
