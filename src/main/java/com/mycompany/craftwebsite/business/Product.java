
package com.mycompany.craftwebsite.business;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;
    private String productName;
    private String productDesc;
    private double price;
    private String category;
    private int stockQuantity;
     public Product() {
       
        this.productName = "";
        this.productDesc = "";
        this.price = 0;
        this.category = "";
        this.stockQuantity = 0;

     }
    public Product(int productID, String productName, String productDesc, double price, String category, int stockQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.productDesc = productDesc;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
    }
    
    public int getProductID() {
        return productID;
    }
    
    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
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

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
