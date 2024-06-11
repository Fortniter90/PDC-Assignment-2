/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc.assignment.services;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pdc.assignment.model.Locations;
import pdc.assignment.pkg2.BaseLog;
import static pdc.assignment.pkg2.BaseLog.logger;
import pdc.assignment.pkg2.HibernateUtil;

/**
 *
 * @author Ethan
 */
public class LocationManagement extends BaseLog implements LocationInterface {

    @Override
    public boolean addLocation(Locations location) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        boolean status = false;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Locations where name=:name");
            query.setParameter("name", location.getName());

            if (query.uniqueResult() == null) {
                session.save(location);
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
    public List<Locations> browseLocations() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        List<Locations> locations = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Locations");
            locations = query.list();
            for (Locations location : locations) {
                System.out.println("Name: " + location.getName());
            }
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.info("ERROR Occurs in ItemManagement - addItem!");
            e.printStackTrace();
        }
        return locations;
    }

    @Override
    public boolean deleteLocation(Locations location) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        boolean status = false;
        try {
            transaction = session.beginTransaction();
            Locations loadedLocation = (Locations) session.get(Locations.class, location.getId());
            if (loadedLocation != null) {
            // Delete all items that reference this location
            Query deleteItemsQuery = session.createQuery("DELETE FROM Items WHERE location.id = :locationId");
            deleteItemsQuery.setParameter("locationId", loadedLocation.getId());
            deleteItemsQuery.executeUpdate();
            
            // Now delete the location
            session.delete(loadedLocation);
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
    public Locations loadLocation(String location) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        Locations locationName = null;
        try {
            transaction = session.beginTransaction();
            String hql = "FROM Locations WHERE name = :locationName";
            Query query = session.createQuery(hql);
            query.setParameter("locationName", location);
            List<Locations> locationsList = query.list();
            if (!locationsList.isEmpty()) {
                locationName = locationsList.get(0);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.info("ERROR Occurs in ItemManagement - addItem!");
            e.printStackTrace();
        }
        return locationName;
    }
}
