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
    
    public boolean transferItem(Transfer transfer);
    
    public List<Transfer> browseTransfers();
}
