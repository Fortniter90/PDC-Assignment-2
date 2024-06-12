/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.Dimension;
import javax.swing.JFrame;
import pdc.assignment.view.LocationPanel;

/**
 *
 * @author Ethan
 */
public class Main {
    //Runs Application By Openning Location Panel
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
    }

}
