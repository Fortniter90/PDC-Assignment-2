/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import pdc.assignment.model.Items;
import pdc.assignment.services.ItemInterface;
import pdc.assignment.services.ItemManagement;
import pdc.assignment.model.Locations;
import pdc.assignment.services.LocationInterface;
import pdc.assignment.services.LocationManagement;
import java.util.List;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import pdc.assignment.pkg2.HibernateUtil;

/**
 *
 * @author Ethan
 */
public class Main {

    public static void main(String[] args) {

        ItemInterface it = new ItemManagement();
        LocationInterface loc = new LocationManagement();
        
        Locations loc1 = new Locations("Peppe Palaece", "119 road");
        
        
        Items it1 = new Items("pep1", 20.16, "Weird", 10, loc1);
        //loc.addLocation(loc1);
       // it.addItem(it1);
        
       // loc.browseLocations();
       // Locations locc2 = loc.loadLocation("Location2");
        
       Locations locc3 = loc.loadLocation("Location3");
   //   loc.deleteLocation(locc2);
     // loc.deleteLocation(locc3);
      //  loc.browseLocations();
       
        it.browseItems();
       
       
        
   // it.searchItemByName("pep1");
   // it.searchItemByPrice(20.16);
       // it.searchItemByQuantity(10);
      // it.searchItemByCategory("Weird");
      
      //
     
        
        HibernateUtil.shutdown();
        
    }

}
