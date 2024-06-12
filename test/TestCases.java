/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pdc.assignment.model.Items;
import pdc.assignment.model.Locations;
import pdc.assignment.model.Transfer;
import pdc.assignment.services.ItemInterface;
import pdc.assignment.services.ItemManagement;

import pdc.assignment.services.LocationInterface;
import pdc.assignment.services.LocationManagement;
import pdc.assignment.services.TransferInterface;
import pdc.assignment.services.TransferManagement;

/**
 *
 * @author Ethan
 */
public class TestCases {
    
       private LocationInterface locationService;
       private ItemInterface itemService;
       private TransferInterface transferService;
       
       @Before
       public void setup(){
           transferService = new TransferManagement();
           locationService = new LocationManagement();
           itemService = new ItemManagement();
       }
       
       
       
       
       @Test
       public void testAddLocationAndDeleteLocation(){
          Locations location = new Locations("Location1", "Address1");
          assertTrue(locationService.addLocation(location));
          assertTrue(locationService.deleteLocation(location));
       }
       
       
       @Test
       public void testAddLocationTwice(){
          Locations location = new Locations("Location1", "Address1");
          locationService.addLocation(location);
          assertTrue("Fail: This will fail as adding two locations with the same name is not allowed", locationService.addLocation(location));
       }
       
       @After
       public void deleteLocation(){
        Locations location  = locationService.loadLocation("Location1");
        locationService.deleteLocation(location);
        Locations location2  = locationService.loadLocation("Location2");
        locationService.deleteLocation(location2);
       }
       
       @Test
       public void testAddItemAndDeleteItem(){
          Locations location = new Locations("Location1", "Address1");
          Locations location2 = new Locations("Location2", "Address2");
          locationService.addLocation(location);
          locationService.addLocation(location2);
          Items item = new Items("Item1", 14.40, 20, location);
          assertTrue(itemService.addItem(item));
          assertFalse(itemService.addItem(item));
          Items item2 = new Items("Item1", 14.40, 20, location2);
          assertTrue(itemService.addItem(item2));
          assertTrue(itemService.deleteItem(item));
          assertTrue(itemService.deleteItem(item2));        
          locationService.deleteLocation(location);
          locationService.deleteLocation(location2);

       }
       
       @Test
       public void testAllSearchItemMethods(){
          Locations location = new Locations("Location1", "Address1");
          assertTrue(locationService.addLocation(location));
          Items item = new Items("Item1", 14.40, 20, location);
          assertTrue(itemService.addItem(item));
          Items item2 = new Items("Item2", 14.80, 30, location);
          itemService.addItem(item2);
          Items item3 = new Items("Item3", 14.40, 20, location);
          itemService.addItem(item3);
          
          assertNotNull(itemService.searchItemByName("Item1"));
          assertNotNull(itemService.searchItemByName("Item2"));
          
          assertNotNull(itemService.searchItemByPrice(14.40));
          assertNotNull(itemService.searchItemByPrice(14.80));
          
          assertNotNull(itemService.searchItemByQuantity(20,location));
          assertNotNull(itemService.searchItemByQuantity(30,location));
          
          locationService.deleteLocation(location);
       }
        
        @Test
        public void testItemTransfer(){
          Locations location = new Locations("Location1", "Address1");
          Locations location2 = new Locations("Location2", "Address2");
          locationService.addLocation(location);
          locationService.addLocation(location2);
          Items item = new Items("Item1", 14.40, 20, location);
          itemService.addItem(item);
          Transfer transfer = new Transfer(item,location,location2,10);
          assertTrue(transferService.transferItem(transfer));
          locationService.deleteLocation(location);
          locationService.deleteLocation(location2);
          }
       
       
  
}
