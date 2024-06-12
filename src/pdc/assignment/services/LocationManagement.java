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

    // Adds a new location to the system.
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
            logger.info("ERROR Occurs in LocationMangement - addLocation!");
            e.printStackTrace();
        }
        return status;
    }

    // Retrieves a list of all locations.
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
            logger.info("ERROR Occurs in LocationMangement - browseLocations!");
            e.printStackTrace();
        }
        return locations;
    }

    // Deletes a specified location from the system.
    @Override
    public boolean deleteLocation(Locations location) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        boolean status = false;
        try {
            transaction = session.beginTransaction();
            Locations loadedLocation = (Locations) session.get(Locations.class, location.getId());
            if (loadedLocation != null) {

                // Delete related transfers where location is source
                Query deleteItemsQuery2 = session.createQuery("DELETE FROM Transfer WHERE sourceLocation.id = :locationId");
                deleteItemsQuery2.setParameter("locationId", loadedLocation.getId());
                deleteItemsQuery2.executeUpdate();

                // Delete related transfers where location is destination
                Query deleteItemsQuery3 = session.createQuery("DELETE FROM Transfer WHERE destLocation.id = :locationId");
                deleteItemsQuery3.setParameter("locationId", loadedLocation.getId());
                deleteItemsQuery3.executeUpdate();
                
                Query deleteItemsQuery = session.createQuery("DELETE FROM Items WHERE location.id = :locationId");
                deleteItemsQuery.setParameter("locationId", loadedLocation.getId());
                deleteItemsQuery.executeUpdate();
                
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
            logger.info("ERROR Occurs in LocationMangement - deleteLocation!");
            e.printStackTrace();
        }
        return status;
    }

    // Loads a specific location by its name.
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
            logger.info("ERROR Occurs in LocationMangement - loadLocation!");
            e.printStackTrace();
        }
        return locationName;
    }
}