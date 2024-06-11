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
            logger.info("ERROR Occurs in ItemManagement - addItem!");
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
            logger.info("ERROR Occurs in ItemManagement - addItem!");
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean updateQuantity(Items item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
            logger.info("ERROR Occurs in ItemManagement - addItem!");
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
            logger.info("ERROR Occurs in ItemManagement - addItem!");
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
            logger.info("ERROR Occurs in ItemManagement - addItem!");
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
            logger.info("ERROR Occurs in ItemManagement - addItem!");
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
            logger.info("ERROR Occurs in ItemManagement - addItem!");
            e.printStackTrace();
        }
        return itemName;
    }

}
