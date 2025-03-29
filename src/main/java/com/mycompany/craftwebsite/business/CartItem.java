package com.mycompany.craftwebsite.business;

import com.mycompany.craftwebsite.ProductDAO;

public class CartItem {
    private int cartItemId;
    private int productId;
    private int quantity;
    private double totalPrice;

    public CartItem(Product product) {
        this.cartItemId = 0;
        this.productId = product.getProductID();
        this.quantity = 1;
        this.totalPrice = product.getPrice();
    }

    // Getters and Setters
    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        setTotalPrice(quantity * getTotalPrice());  // Recalculate total price if quantity changes
    }

     
    public double getTotalPrice() {
        return totalPrice;
    }

    private void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public void increaseQuantity() {
        this.quantity++;
    }
}
