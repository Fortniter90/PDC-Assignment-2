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

    @Override
    public boolean addItem(Items item) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        boolean status = false;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Items where location=:location and name=:name");
            query.setParameter("name", item.getName());
            query.setParameter("location", item.getLocation());

            if (query.uniqueResult() == null) {
                session.save(item);
                status = true;
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.info("ERROR Occurs in ItemManagement - addItem!");
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public List<Items> browseItems() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        List<Items> items = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Items");
            items = query.list();
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
        return items;
    }

    @Override
    public boolean deleteItem(Items item) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        boolean status = false;
        try {
            transaction = session.beginTransaction();
            Items loadedItems = (Items) session.get(Items.class, item.getId());
            if (loadedItems != null) {
                session.delete(loadedItems);
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
    
    public boolean removeItemByName(String itemName, int quantityToRemove) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        boolean removed = false;
        try {
            transaction = session.beginTransaction();
            // Query the database to find the item by name
            Query query = session.createQuery("FROM Items WHERE name = :itemName");
            query.setParameter("itemName", itemName);
            Items itemToRemove = (Items) query.uniqueResult();
            if (itemToRemove != null) {
                // Update the quantity
                int newQuantity = itemToRemove.getQuantity() - quantityToRemove;
                if (newQuantity >= 0) { // Ensure quantity doesn't go negative
                    itemToRemove.setQuantity(newQuantity);
                    session.update(itemToRemove); // Update the item in the database
                    transaction.commit();
                    removed = true;
                } else {
                    transaction.rollback(); // Quantity cannot go negative
                }
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.info("ERROR Occurs in ItemManagement - removeItemByName!");
            e.printStackTrace();
        }
        return removed;
    }
    
    public boolean reduceItemQuantity(Items item, int quantityToRemove) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        boolean status = false;
        try {
            transaction = session.beginTransaction();
            Items loadedItem = (Items) session.get(Items.class, item.getId());
            if (loadedItem != null) {
                int currentQuantity = loadedItem.getQuantity();
                if (currentQuantity >= quantityToRemove) {
                    loadedItem.setQuantity(currentQuantity - quantityToRemove);
                    session.update(loadedItem);
                    transaction.commit();
                    status = true;
                } else {
                    // Not enough quantity available to remove
                    transaction.rollback();
                }
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.info("ERROR Occurs in ItemManagement - reduceItemQuantity!");
            e.printStackTrace();
        } finally {
            session.close(); // Close the session
        }
        return status;
    }

    @Override
    public boolean updateQuantity(Items item, int amount) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        boolean status = false;
        try {
            transaction = session.beginTransaction();
            Items loadedItems = (Items) session.get(Items.class, item.getId());
            if (loadedItems != null) {
                loadedItems.setQuantity(amount);
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
            logger.info("ERROR Occurs in ItemManagement - deleteItem!");
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public List<Items> searchItemByName(String name) {
         Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        List<Items> items = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Items where name=:name");
            query.setParameter("name", name);
            items = query.list();
            if(!items.isEmpty()){
            for (Items item : items) {
                Locations location = item.getLocation();
                System.out.println(item.toString() + ", Location: " + location.getName());

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
        return null;
    }

    @Override
    public List<Items> searchItemByQuantity(int quantity) {
Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        List<Items> items = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Items where quantity=:quantity");
            query.setParameter("quantity", quantity);
            items = query.list();
            if(!items.isEmpty()){
            for (Items item : items) {
                Locations location = item.getLocation();
                System.out.println(item.toString() + ", Location: " + location.getName());

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

    @Override
    public List<Items> searchItemByCategory(String category) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        List<Items> items = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Items where category=:category");
            query.setParameter("category", category);
            items = query.list();
            if(!items.isEmpty()){
            for (Items item : items) {
                Locations location = item.getLocation();
                System.out.println(item.toString() + ", Location: " + location.getName());

            }
            transaction.commit();
            return items;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.info("ERROR Occurs in ItemManagement - searchItemByCategory!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Items> searchItemByPrice(double price) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        List<Items> items = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Items where price=:price");
            query.setParameter("price", price);
            items = query.list();
            if(!items.isEmpty()){
            for (Items item : items) {
                Locations location = item.getLocation();
                System.out.println(item.toString() + ", Location: " + location.getName());

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

    @Override
    public Items itemLoad(String item) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        Items itemName = null;
        try {
            transaction = session.beginTransaction();
            String hql = "FROM Items WHERE name = :itemName";
            Query query = session.createQuery(hql);
            query.setParameter("itemName", item);
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

}
