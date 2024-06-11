package pdc.assignment.model;

import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Ethan
 */
public class Items implements Serializable {
    private int id;
    
    private Locations location;

    private String name;
    
    private double price;
    
    private int quantity;

    private String category;

    public Items() {}

    public Items(String name, double price, String category, int quantity, Locations location) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.location = location;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString() {
        return "Item [id=" + getId() + ", name=" + getName() + ",quantity= " + getQuantity() + ", price=" + getPrice() + ", category=" + getCategory() + "]";
    }

    /**
     * @return the itemId
     */
    public int getId() {
        return id;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the location
     */
    public Locations getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Locations location) {
        this.location = location;
    }
}
