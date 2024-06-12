/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc.assignment.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Ethan
 */
public class Transfer implements Serializable {
    
    private int id;
    
    private Locations sourceLocation;
    
    private Locations destLocation;
    
    private int quantity;
    
    private Date transferDate;
    
    private Items item;
    
    public Transfer(){};
    
    public Transfer(Items item,Locations sourceLocation, Locations destLocation, int quantity){
        this.item = item;
        this.sourceLocation = sourceLocation;
        this.destLocation = destLocation;
        this.quantity = quantity;
        this.transferDate = new Date();
    }

    /**
     * @return the sourceLocation
     */
    public Locations getSourceLocation() {
        return sourceLocation;
    }

    /**
     * @param sourceLocation the sourceLocation to set
     */
    public void setSourceLocation(Locations sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    /**
     * @return the destLocation
     */
    public Locations getDestLocation() {
        return destLocation;
    }

    /**
     * @param destLocation the destLocation to set
     */
    public void setDestLocation(Locations destLocation) {
        this.destLocation = destLocation;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the transferDate
     */
    public Date getTransferDate() {
        return transferDate;
    }

    /**
     * @param transferDate the transferDate to set
     */
    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    /**
     * @return the item
     */
    public Items getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Items item) {
        this.item = item;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
