/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc.assignment.services;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pdc.assignment.pkg2.HibernateUtil;
import pdc.assignment.model.Items;
import pdc.assignment.pkg2.BaseLog;
import org.hibernate.Query;
import pdc.assignment.model.Locations;

/**
 *
 * @author Ethan
 */
public class ItemManagement extends BaseLog implements ItemInterface {

    // Adds a new item to the inventory.
    @Override
    public boolean addItem(Items item) {
        Session session = HibernateUtil.getSession(); // Obtains a session using the HibernateUtil class
        Transaction transaction = null; // Initializes transaction as null
        boolean status = false; // Initializes status as false which tracks the success of the method

        try {
            transaction = session.beginTransaction(); // Begins a new transaction
            // Creates a query to check if an item with the same name and location already exists
            Query query = session.createQuery("FROM Items where location=:location and name=:name");
            query.setParameter("name", item.getName()); // Sets the name parameter in the query
            query.setParameter("location", item.getLocation()); // Sets the location parameter in the query

            // If no matching item is found, save the new item
            if (query.uniqueResult() == null) {
                session.save(item); // Saves the item to the database
                status = true; // Sets status to true showing the operation was successful
            }

            transaction.commit(); // Commits the transaction to persist the changes
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Rolls back the transaction in case of an error
            }
            logger.info("ERROR Occurs in ItemManagement - addItem!"); // Logs an error message
            e.printStackTrace(); // Prints the stack trace for debugging purposes
        }

        return status; // Returns the status indicating the success or failure of the operation
    }

    // Retrieves a list of all items in the inventory.
    @Override
    public List<Items> browseItems() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        List<Items> items = null;
        try {
            transaction = session.beginTransaction();
            // Creates a query to get all items from the Items table
            Query query = session.createQuery("FROM Items");
            items = query.list(); // Puts the items in a list
            // Iterates through the list and prints all the items
            for (Items item : items) {
                Locations location = item.getLocation();
                System.out.println(item.toString() + ", Location: " + location.getName());

            }
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.info("ERROR Occurs in ItemManagement - browseItems!");
            e.printStackTrace();
        }
        return items; // Returns all the items in the list
    }

    // Retrieves a list of items available at a specific location.
    @Override
    public List<Items> browseItemsByLocation(Locations location) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        List<Items> items = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Items where location.id =:location");
            query.setParameter("location", location.getId());
            items = query.list();
            for (Items item : items) {
                System.out.println(item.toString());
            }
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.info("ERROR Occurs in ItemManagement - browseItems!");
            e.printStackTrace();
        }
        return items;
    }

    // Deletes an item from the inventory.
    @Override
    public boolean deleteItem(Items item) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        boolean status = false;
        try {
            transaction = session.beginTransaction();
            Items loadedItems = (Items) session.get(Items.class, item.getId()); // Loads the item from the items table using the current session
            if (loadedItems != null) {
                // Create a query that deletes all the transfer rows that have the specific item id
                Query deleteItemsQuery = session.createQuery("DELETE FROM Transfer WHERE item.id = :itemId");
                deleteItemsQuery.setParameter("itemId", loadedItems.getId());
                deleteItemsQuery.executeUpdate(); // Executes deletion of transfer rows
                session.delete(loadedItems); // Deletes the item
                transaction.commit();
                status = true;
            } else {
                transaction.rollback();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.info("ERROR Occurs in ItemManagement - deleteItem!");
            e.printStackTrace();
        }
        return status;
    }

    // Updates the quantity of a specific item in the inventory.
    @Override
    public boolean updateQuantity(Items item, int amount) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        boolean status = false;
        try {
            transaction = session.beginTransaction();
            Items loadedItems = (Items) session.get(Items.class, item.getId());
            if (loadedItems != null) {
                loadedItems.setQuantity(amount); // Sets the new quantity of item
                session.update(loadedItems);
                transaction.commit();
                status = true;
            } else {
                transaction.rollback();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.info("ERROR Occurs in ItemManagement - updateQuantity!");
            e.printStackTrace();
        }
        return status;
    }

    // Searches for items by their name within a specific location.
    @Override
    public List<Items> searchItemByName(String name, Locations location) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        List<Items> items = null;
        try {
            transaction = session.beginTransaction();
            // Creates a query to find all items within the location with that specific name
            Query query = session.createQuery("FROM Items where location.id=:location and name=:name");
            query.setParameter("location", location.getId());
            query.setParameter("name", name);
            items = query.list();
            if (!items.isEmpty()) {
                // Iterates through all the items that the query finds
                for (Items item : items) {
                    Locations locations = item.getLocation();
                    System.out.println(item.toString() + ", Location: " + locations.getName());
                }
                transaction.commit();
                return items;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.info("ERROR Occurs in ItemManagement - searchItemByName!");
            e.printStackTrace();
        }
        session.close();
        return null;
    }

    // Searches for items by their quantity within a specific location.
    @Override
    public List<Items> searchItemByQuantity(int quantity, Locations location) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        List<Items> items = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Items where location.id=:location and quantity=:quantity");
            query.setParameter("location", location.getId());
            query.setParameter("quantity", quantity);
            items = query.list();
            if (!items.isEmpty()) {
                for (Items item : items) {
                    Locations locations = item.getLocation();
                    System.out.println(item.toString() + ", Location: " + locations.getName());

                }
                transaction.commit();
                return items;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.info("ERROR Occurs in ItemManagement - searchItemByQuantity!");
            e.printStackTrace();
        }
        return null;
    }

    // Searches for items by their price within a specific location.
    @Override
    public List<Items> searchItemByPrice(double price, Locations location) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        List<Items> items = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Items where location.id=:location and price=:price");
            query.setParameter("location", location.getId());
            query.setParameter("price", price);
            items = query.list();
            if (!items.isEmpty()) {
                for (Items item : items) {
                    Locations locations = item.getLocation();
                    System.out.println(item.toString() + ", Location: " + locations.getName());

                }
                transaction.commit();
                return items;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.info("ERROR Occurs in ItemManagement - searchItemByPrice!");
            e.printStackTrace();
        }
        return null;
    }

    // Loads item details from a specific location.
    @Override
    public Items itemLoad(String item, Locations location) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        Items itemName = null;
        try {
            transaction = session.beginTransaction();
            String hql = "FROM Items where location=:location and name=:name";
            Query query = session.createQuery(hql);
            query.setParameter("name", item);
            query.setParameter("location", location);
            List<Items> itemsList = query.list();
            if (!itemsList.isEmpty()) {
                itemName = itemsList.get(0);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.info("ERROR Occurs in ItemManagement - itemLoad!");
            e.printStackTrace();
        }
        return itemName;
    }

    // Adds a new item to the inventory during a transfer session.
    @Override
    public boolean transferAddItem(Session session, Items item) {
        boolean status = false;
        try {
            Query query = session.createQuery("FROM Items where location=:location and name=:name");
            query.setParameter("name", item.getName());
            query.setParameter("location", item.getLocation());

            if (query.uniqueResult() == null) {
                session.save(item);
                status = true;
            }
        } catch (Exception e) {
            logger.info("ERROR Occurs in ItemManagement - transferAddItem!");
            e.printStackTrace();
        }
        return status;
    }

    // Loads item details during a transfer session from a specific location.
    @Override
    public Items itemTransferLoad(Session session, String item, Locations destLocation) {
        Items itemName = null;
        try {
            String hql = "FROM Items where location=:location and name=:name";
            Query query = session.createQuery(hql);
            query.setParameter("name", item);
            query.setParameter("location", destLocation);
            List<Items> itemsList = query.list();
            if (!itemsList.isEmpty()) {
                itemName = itemsList.get(0);
            }
        } catch (Exception e) {
            logger.info("ERROR Occurs in ItemManagement - itemTransferLoad!");
            e.printStackTrace();
        }
        return itemName;
    }
}