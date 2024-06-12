/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pdc.assignment.services;

import java.util.List;
import pdc.assignment.model.Locations;

/**
 *
 * @author Ethan
 */
public interface LocationInterface {
    
    /**
     * Adds a new location to the system.
     *
     * @param location The location to be added.
     * @return true if the location was successfully added, false otherwise.
     */
    public boolean addLocation(Locations location);
    
    /**
     * Retrieves a list of all locations.
     *
     * @return A list of all locations.
     */
    public List<Locations> browseLocations();
    
    /**
     * Loads a specific location by its name.
     *
     * @param location The name of the location to load.
     * @return The location object matching the provided name.
     */
    public Locations loadLocation(String location);
    
    /**
     * Deletes a specified location from the system.
     *
     * @param location The location to be deleted.
     * @return true if the location was successfully deleted, false otherwise.
     */
    public boolean deleteLocation(Locations location);
}
