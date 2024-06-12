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
import pdc.assignment.model.Transfer;
import pdc.assignment.pkg2.HibernateUtil;
import pdc.assignment.services.TransferInterface;
import pdc.assignment.services.TransferManagement;

/**
 *
 * @author Ethan
 */
public class Main {

    public static void main(String[] args) {

        ItemInterface it = new ItemManagement();
        LocationInterface loc = new LocationManagement();
        TransferInterface tran = new TransferManagement();
        
        Locations lo1 = new Locations("Peppe Palaece", "10 road");
        
        
     //  loc.addLocation(lo1);
      //  it.addItem(it1);
 //       it.updateQuantity(it1, 20);
       // loc.browseLocations();
      Locations locc2 = loc.loadLocation("Peppe Palaece");
              Items it1 = new Items("Woek", 20.16, 10, locc2);

      //        it.addItem(it1);

       loc.browseLocations(); 
       Items itt1 = it.itemLoad("Woek", null);
       Locations locc3 = loc.loadLocation("Peppe Palaece2");
       
       Transfer trans = new Transfer(itt1,locc2,locc3,1);
       
   //   tran.transferItem(trans);
       
     // it.deleteItem(itt1);
    
    // loc.deleteLocation(locc2);
   //    loc.deleteLocation(locc3);
       loc.browseLocations();
       
        it.browseItems();
        tran.browseTransfers();
       
       
        
   // it.searchItemByName("pep1");
   // it.searchItemByPrice(20.16);
       // it.searchItemByQuantity(10);
      // it.searchItemByCategory("Weird");
      
      
     
        
        HibernateUtil.shutdown();
        
    }

}
