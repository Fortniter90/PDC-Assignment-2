/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pdc.assignment.view;

import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import pdc.assignment.model.Items;
import pdc.assignment.model.Locations;
import pdc.assignment.pkg2.HibernateUtil;
import pdc.assignment.services.ItemInterface;
import pdc.assignment.services.ItemManagement;

/**
 *
 * @author klinsmann
 */
public class DisplayItems extends javax.swing.JPanel {

    private JFrame parentFrame;
    private final Locations location;
    /**
     * Creates new form DisplayItems
     */
    public DisplayItems(Locations location,JFrame parentFrame) {
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
        setItemList();
    }
    
    //Turns items from list into strings
    public List<String> itemsToStrings(List<Items> items){
        List <String> strings = new ArrayList<>();
        for(Items item : items){
            strings.add(item.toString());
        }
        return strings;
    }
    
    //Loads strings into itemlist panel
    private void setItemList() {
    ItemInterface it = new ItemManagement();
    List<Items> items = it.browseItemsByLocation(location);
    DefaultListModel<String> listModel = new DefaultListModel<>();
    List<String> itemStrings = itemsToStrings(items);
    if (!itemStrings.isEmpty()) {
        for (String itemString : itemStrings) {
            listModel.addElement(itemString);
        }
    } else {
        listModel.addElement("No Items");
    }
    itemList.setModel(listModel);
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
        itemList = new javax.swing.JList<>();
        displayItemBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();

        jScrollPane1.setViewportView(itemList);

        displayItemBack.setText("Go back");
        displayItemBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayItemBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Items in this location");

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exit)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(224, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(displayItemBack)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(224, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(displayItemBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(exit)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void displayItemBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayItemBackActionPerformed
        // TODO add your handling code here:

        JFrame itemPanelFrame = new JFrame("Item Panel");
        itemPanelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        itemPanelFrame.setSize(850, 690);
        itemPanelFrame.add(new ItemPanel(location,itemPanelFrame));
        itemPanelFrame.setLocationRelativeTo(null); //center the frame
        itemPanelFrame.setVisible(true);

        parentFrame.dispose(); //close panel
    }//GEN-LAST:event_displayItemBackActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton displayItemBack;
    private javax.swing.JButton exit;
    private javax.swing.JList<String> itemList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
