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
    
    public boolean addLocation(Locations location);
    
    public List<Locations> browseLocations();
    
    public Locations loadLocation(String location);
    
    public boolean deleteLocation(String location);    
}
