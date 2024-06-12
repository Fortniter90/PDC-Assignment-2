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
   /**
     * Adds a new item to the inventory.
     * 
     * @param item The item to be added.
     * @return true if the item is successfully added, false otherwise.
     */
    public boolean addItem(Items item);

    /**
     * Retrieves a list of all items in the inventory.
     * 
     * @return A list of all items.
     */
    public List<Items> browseItems();

    /**
     * Retrieves a list of items available at a specific location.
     * 
     * @param location The location to filter items by.
     * @return A list of items available at the specified location.
     */
    public List<Items> browseItemsByLocation(Locations location);

    /**
     * Deletes an item from the inventory.
     * 
     * @param item The item to be deleted.
     * @return true if the item is successfully deleted, false otherwise.
     */
    public boolean deleteItem(Items item);

    /**
     * Updates the quantity of a specific item in the inventory.
     * 
     * @param item The item whose quantity is to be updated.
     * @param amount The new quantity to be set.
     * @return true if the quantity is successfully updated, false otherwise.
     */
    public boolean updateQuantity(Items item, int amount);

    /**
     * Searches for items by their name within a specific location.
     * 
     * @param name The name of the item to search for.
     * @param location The location to filter items by.
     * @return A list of items matching the name within the specified location.
     */
    public List<Items> searchItemByName(String name, Locations location);

    /**
     * Searches for items by their quantity within a specific location.
     * 
     * @param quantity The quantity to filter items by.
     * @param location The location to filter items by.
     * @return A list of items matching the quantity within the specified location.
     */
    public List<Items> searchItemByQuantity(int quantity, Locations location);

    /**
     * Searches for items by their price within a specific location.
     * 
     * @param price The price to filter items by.
     * @param location The location to filter items by.
     * @return A list of items matching the price within the specified location.
     */
    public List<Items> searchItemByPrice(double price, Locations location);

    /**
     * Loads item details for transfer to a different location.
     * 
     * @param session The session initiating the transfer.
     * @param item The name of the item to be transferred.
     * @param destLocation The destination location for the transfer.
     * @return The item details to be transferred.
     */
    public Items itemTransferLoad(Session session, String item, Locations destLocation);

    /**
     * Loads item details from a specific location.
     * 
     * @param item The name of the item to be loaded.
     * @param location The location from which the item is to be loaded.
     * @return The item details from the specified location.
     */
    public Items itemLoad(String item, Locations location);

    /**
     * Transfers item to new location using the current session.
     * 
     * @param session The session to which the item is to be added.
     * @param item The item to be added.
     * @return true if the item is successfully added to the session, false otherwise.
     */
    public boolean transferAddItem(Session session, Items item);
}
