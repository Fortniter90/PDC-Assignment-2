/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.Dimension;
import pdc.assignment.model.Items;
import pdc.assignment.services.ItemInterface;
import pdc.assignment.services.ItemManagement;
import pdc.assignment.model.Locations;
import pdc.assignment.services.LocationInterface;
import pdc.assignment.services.LocationManagement;
import java.util.List;
import javax.swing.JFrame;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import pdc.assignment.model.Transfer;
import pdc.assignment.pkg2.HibernateUtil;
import pdc.assignment.services.TransferInterface;
import pdc.assignment.services.TransferManagement;
import pdc.assignment.view.LocationPanel;

/**
 *
 * @author Ethan
 */
public class Main {

    public static void main(String[] args) {
    JFrame frame = new JFrame("Location Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set the preffered size of window
        frame.setPreferredSize(new Dimension(850, 690));

        //set minimum size of window
        frame.setMinimumSize(new Dimension(850, 690));

        frame.getContentPane().add(new LocationPanel(frame));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        HibernateUtil.shutdown();
        
    }

}
