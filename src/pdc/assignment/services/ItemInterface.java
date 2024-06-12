/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pdc.assignment.services;

import java.util.List;
import org.hibernate.Session;
import pdc.assignment.model.Items;
import pdc.assignment.model.Locations;

/**
 *
 * @author Ethan
 */
public interface ItemInterface {
    
    public boolean addItem(Items item);
    
    public List<Items> browseItems();
    
    public boolean deleteItem(Items item);
    
    public boolean updateQuantity(Items item, int amount);
    
    public List<Items> searchItemByName(String name);
    
    public List<Items> searchItemByQuantity(int quantity);
    
    public List<Items> searchItemByCategory(String category);
    
    public List<Items> searchItemByPrice(double price);
    
    public Items itemTransferLoad(Session session, String item, Locations destLocation);
    
    public Items itemLoad(String item, Locations location);

    public boolean transferAddItem(Session session, Items item);

}
