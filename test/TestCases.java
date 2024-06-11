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
import pdc.assignment.services.ItemInterface;
import pdc.assignment.services.ItemManagement;

import pdc.assignment.services.LocationInterface;
import pdc.assignment.services.LocationManagement;

/**
 *
 * @author Ethan
 */
public class TestCases {
    
       private LocationInterface locationService;
       private ItemInterface itemService;
       
       @Before
       public void setup(){
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
       }
       
       @Test
       public void testAddItemAndDeleteItem(){
          Locations location = new Locations("Location1", "Address1");
          Locations location2 = new Locations("Location2", "Address2");
          locationService.addLocation(location);
          locationService.addLocation(location2);
          Items item = new Items("Item1", 14.40, "Category1", 20, location);
          assertTrue(itemService.addItem(item));
          assertFalse(itemService.addItem(item));
          Items item2 = new Items("Item1", 14.40, "Category1", 20, location2);
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
          Items item = new Items("Item1", 14.40, "Category1", 20, location);
          assertTrue(itemService.addItem(item));
          Items item2 = new Items("Item2", 14.80, "Category1", 30, location);
          itemService.addItem(item2);
          Items item3 = new Items("Item3", 14.40, "Category2", 20, location);
          itemService.addItem(item3);
          
         assertNotNull(itemService.searchItemByName("Item1"));
         assertNotNull(itemService.searchItemByName("Item2"));
          
          assertNotNull(itemService.searchItemByCategory("Category1"));
          assertNotNull(itemService.searchItemByCategory("Category2"));
          
          assertNotNull(itemService.searchItemByPrice(14.40));
          assertNotNull(itemService.searchItemByPrice(14.80));
          
          assertNotNull(itemService.searchItemByQuantity(20));
          assertNotNull(itemService.searchItemByQuantity(30));
          
          locationService.deleteLocation(location);
       }
  
}
