/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.craftwebsite.business;

import java.sql.Timestamp;


public class Orders {
   private int orderID;
   private int userID;
   private double totalPrice;
   private Timestamp orderDate;
   
    public Orders(int orderID, int userID, double totalPrice, Timestamp orderDate) {
        this.orderID = orderID;
        this.userID = userID;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }
   public int getOrderID() {
        return orderID;
    }
   
   public void setOrderID(int orderID) {
       this.orderID = orderID;
   }

    public int getUserID() {
        return userID;
    }
    
    public void setUserID(int userID) {
       this.userID = userID;
   }

    public double getTotalPrice() {
        return totalPrice;
    }
    
        
    public void setTotalPrice(double totalPrice) {
       this.totalPrice = totalPrice;
   }

    public Timestamp getOrderDate() {
        return orderDate;
    }
    
    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }
}