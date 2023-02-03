package com.productassignmentspringjdbc.product;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.UUID;

public class Product {

//    private UUID product_id;
    private int id;
    private String name;
    private int quantity;
    private double price;
    private String description;
    private boolean isAvailable;


    public Product(){

    }


    public Product(int id, String name, String description, int quantity, double price, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.isAvailable = isAvailable;
    }

    public Product(String name, String description, int quantity, double price, boolean isAvailable) {
//        this.product_id = product_id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.isAvailable = isAvailable;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
