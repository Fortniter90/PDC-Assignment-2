/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pdc.assignment.services;

import java.util.List;
import pdc.assignment.model.Transfer;

/**
 *
 * @author Ethan
 */
public interface TransferInterface {
    /**
     * Transfers an item to another location.
     *
     * @param transfer the object that holds all the transfer information
     * @return true if the location was successfully added, false otherwise.
     */
    public boolean transferItem(Transfer transfer);
    
    /**
     * Retrieves a list of all the transfers.
     *
     * @return true if the location was successfully added, false otherwise.
     */
    public List<Transfer> browseTransfers();
}
