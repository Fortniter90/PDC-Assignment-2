/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pdc.assignment.services;

import java.util.List;
import pdc.assignment.model.Items;

/**
 *
 * @author Ethan
 */
public interface ItemInterface {
    
    public boolean addItem(Items item);
    
    public List<Items> browseItems();
    
    public Items itemLoad(String item);
    
    public boolean deleteItem(Items item);
    
    public boolean updateQuantity(Items item, int amount);
    
    public List<Items> searchItemByName(String name);
    
    public List<Items> searchItemByQuantity(int quantity);
    
    public List<Items> searchItemByCategory(String category);
    
    public List<Items> searchItemByPrice(double price);

}
