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
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import pdc.assignment.services.ItemManagement;
import pdc.assignment.model.Items;
import pdc.assignment.model.Locations;
import pdc.assignment.pkg2.HibernateUtil;
/**
 *
 * @author klinsmann
 */
public class SearchByName extends javax.swing.JPanel {
    
    private final Locations location;
    private JFrame parentFrame;
    /**
     * Creates new form SearchByName
     */
    public SearchByName(Locations location,JFrame parentFrame) {
        this.location = location;
        this.parentFrame = parentFrame;
        initComponents();
        
        loadItemsIntoList();
        
        parentFrame.setMinimumSize(new Dimension(850, 690));
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
    }

    private void loadItemsIntoList() {
        ItemManagement itemManagement = new ItemManagement();
        List<Items> items = itemManagement.browseItems();
        if (items != null && !items.isEmpty()) {
            DefaultListModel<String> listModel = new DefaultListModel<>();
            for (Items item : items) {
                listModel.addElement(item.toString() + " - Location: " + item.getLocation().getName());
            }
            searchByNameList.setModel(listModel);
        } else {
            JOptionPane.showMessageDialog(this, "No items found.", "Info", JOptionPane.INFORMATION_MESSAGE);
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
        searchByNameList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        searchByNameInput = new javax.swing.JTextField();
        searchByNameBack = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        searchByNameSearch = new javax.swing.JButton();

        jScrollPane1.setViewportView(searchByNameList);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Search by Name");

        searchByNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByNameInputActionPerformed(evt);
            }
        });

        searchByNameBack.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchByNameBack.setText("Go back");
        searchByNameBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByNameBackActionPerformed(evt);
            }
        });

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        searchByNameSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchByNameSearch.setText("Search");
        searchByNameSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByNameSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(searchByNameBack)
                            .addGap(100, 100, 100)
                            .addComponent(searchByNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchByNameSearch))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchByNameBack)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(searchByNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchByNameSearch))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchByNameBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByNameBackActionPerformed
        // TODO add your handling code here:

        JFrame itemPanelFrame = new JFrame("Item Panel");
        itemPanelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        itemPanelFrame.setSize(850, 690);
        itemPanelFrame.add(new ItemPanel(location,itemPanelFrame));
        itemPanelFrame.setLocationRelativeTo(null); //center the frame
        itemPanelFrame.setVisible(true);

        parentFrame.dispose(); //close panel
    }//GEN-LAST:event_searchByNameBackActionPerformed

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

    private void searchByNameSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByNameSearchActionPerformed
        // TODO add your handling code here:
        String name = searchByNameInput.getText().trim();
        if (!name.isEmpty()) {
            ItemManagement itemManagement = new ItemManagement();
            List<Items> items = itemManagement.searchItemByName(name,location);
            if (items != null && !items.isEmpty()) {
                DefaultListModel<String> listModel = new DefaultListModel<>();
                for (Items item : items) {
                    listModel.addElement(item.toString() + " - Location: " + item.getLocation().getName());
                }
                searchByNameList.setModel(listModel);
            } else {
                JOptionPane.showMessageDialog(this, "No items found for the given name.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a name to search.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_searchByNameSearchActionPerformed

    
    private void searchByNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByNameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchByNameInputActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchByNameBack;
    private javax.swing.JTextField searchByNameInput;
    private javax.swing.JList<String> searchByNameList;
    private javax.swing.JButton searchByNameSearch;
    // End of variables declaration//GEN-END:variables
}
