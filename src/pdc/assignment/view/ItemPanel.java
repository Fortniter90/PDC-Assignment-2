/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pdc.assignment.view;

import java.awt.Dimension;
import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


/**
 *
 * @author dhy6184
 */
public class ItemPanel extends javax.swing.JPanel {
    
    private JFrame parentFrame;
    
    /**
     * Creates new form ItemPanel
     */
    public ItemPanel(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        initComponents();
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        removeItem = new javax.swing.JButton();
        addItem = new javax.swing.JButton();
        searchItem = new javax.swing.JButton();
        displayItems = new javax.swing.JButton();
        transferItems = new javax.swing.JButton();
        itempanelback = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        updateQuantity = new javax.swing.JButton();
        displayTransfers = new javax.swing.JButton();

        removeItem.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        removeItem.setText("Remove an Item");
        removeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeItemActionPerformed(evt);
            }
        });

        addItem.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        addItem.setText("Add an item");
        addItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemActionPerformed(evt);
            }
        });

        searchItem.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        searchItem.setText("Search Items");
        searchItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchItemActionPerformed(evt);
            }
        });

        displayItems.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        displayItems.setText("Display all Items");
        displayItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayItemsActionPerformed(evt);
            }
        });

        transferItems.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        transferItems.setText("Tranfer Item");
        transferItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferItemsActionPerformed(evt);
            }
        });

        itempanelback.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        itempanelback.setText("Select Location");
        itempanelback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itempanelbackActionPerformed(evt);
            }
        });

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Item Management");

        updateQuantity.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        updateQuantity.setText("Update Quantity");
        updateQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateQuantityActionPerformed(evt);
            }
        });

        displayTransfers.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        displayTransfers.setText("Display Transfers");
        displayTransfers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayTransfersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(346, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(displayTransfers, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addItem, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itempanelback, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchItem, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displayItems, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transferItems, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeItem, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(exit)))
                .addContainerGap(347, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addComponent(addItem, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeItem, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(transferItems, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(displayTransfers, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchItem, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(displayItems, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(itempanelback, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(exit)
                .addContainerGap(48, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemActionPerformed
        // TODO add your handling code here:
        
        JFrame addItemFrame = new JFrame("Add new item");
        addItemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addItemFrame.setSize(850, 690);
        addItemFrame.add(new AddItems(addItemFrame));
        addItemFrame.setLocationRelativeTo(null); //center the frame
        addItemFrame.setVisible(true);      
          
        parentFrame.dispose(); // close panel
    }//GEN-LAST:event_addItemActionPerformed

    private void itempanelbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itempanelbackActionPerformed
        // TODO add your handling code here:
        
        JFrame locationPanelFrame = new JFrame("Location Panel");
        locationPanelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        locationPanelFrame.setSize(850, 690);
        locationPanelFrame.add(new LocationPanel(locationPanelFrame));
        locationPanelFrame.setLocationRelativeTo(null); //center the frame
        locationPanelFrame.setVisible(true);

        parentFrame.dispose(); //close panel
    }//GEN-LAST:event_itempanelbackActionPerformed

    private void removeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeItemActionPerformed
        // TODO add your handling code here:
        
        JFrame removeItemFrame = new JFrame("Remove an item");
        removeItemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        removeItemFrame.setSize(850, 690);
        removeItemFrame.add(new RemoveItem(removeItemFrame));
        removeItemFrame.setLocationRelativeTo(null); //center the frame
        removeItemFrame.setVisible(true);      
          
        parentFrame.dispose(); // close panel
    }//GEN-LAST:event_removeItemActionPerformed

    private void transferItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferItemsActionPerformed
        // TODO add your handling code here:
        
        JFrame transferItemFrame = new JFrame("Transfer an item");
        transferItemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        transferItemFrame.setSize(850, 690);
        transferItemFrame.add(new TransferItem(transferItemFrame));
        transferItemFrame.setLocationRelativeTo(null); //center the frame
        transferItemFrame.setVisible(true);      
          
        parentFrame.dispose(); // close panel
    }//GEN-LAST:event_transferItemsActionPerformed

    private void displayItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayItemsActionPerformed
        // TODO add your handling code here:
        
        JFrame displayItemFrame = new JFrame("List of all items");
        displayItemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        displayItemFrame.setSize(850, 690);
        displayItemFrame.add(new DisplayItems(displayItemFrame));
        displayItemFrame.setLocationRelativeTo(null); //center the frame
        displayItemFrame.setVisible(true);      
          
        parentFrame.dispose(); // close panel
    }//GEN-LAST:event_displayItemsActionPerformed

    private void searchItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchItemActionPerformed
        // TODO add your handling code here:
        
        JFrame searchItemFrame = new JFrame("Search for an item");
        searchItemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        searchItemFrame.setSize(850, 690);
        searchItemFrame.add(new SearchItems(searchItemFrame));
        searchItemFrame.setLocationRelativeTo(null); //center the frame
        searchItemFrame.setVisible(true);      
          
        parentFrame.dispose(); // close panel
    }//GEN-LAST:event_searchItemActionPerformed

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
        }
    }//GEN-LAST:event_exitActionPerformed

    private void updateQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateQuantityActionPerformed
        // TODO add your handling code here:
        
        JFrame updateQuantityFrame = new JFrame("Search for an item");
        updateQuantityFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updateQuantityFrame.setSize(850, 690);
        updateQuantityFrame.add(new UpdateQuantity(updateQuantityFrame));
        updateQuantityFrame.setLocationRelativeTo(null); //center the frame
        updateQuantityFrame.setVisible(true);      
          
        parentFrame.dispose(); // close panel
    }//GEN-LAST:event_updateQuantityActionPerformed

    private void displayTransfersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayTransfersActionPerformed
        // TODO add your handling code here:
                
        JFrame displayTransfersFrame = new JFrame("Search for an item");
        displayTransfersFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        displayTransfersFrame.setSize(850, 690);
        displayTransfersFrame.add(new DisplayTransfers(displayTransfersFrame));
        displayTransfersFrame.setLocationRelativeTo(null); //center the frame
        displayTransfersFrame.setVisible(true);      
          
        parentFrame.dispose(); // close panel
    }//GEN-LAST:event_displayTransfersActionPerformed
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Item Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //set the preffered size of window
        frame.setPreferredSize(new Dimension(850, 690));
    
        //set minimum size of window
        frame.setMinimumSize(new Dimension(850, 690));

        frame.getContentPane().add(new ItemPanel(frame));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItem;
    private javax.swing.JButton displayItems;
    private javax.swing.JButton displayTransfers;
    private javax.swing.JButton exit;
    private javax.swing.JButton itempanelback;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton removeItem;
    private javax.swing.JButton searchItem;
    private javax.swing.JButton transferItems;
    private javax.swing.JButton updateQuantity;
    // End of variables declaration//GEN-END:variables
}
