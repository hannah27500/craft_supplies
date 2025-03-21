
package com.mycompany.craftwebsite.business;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

public class Cart {

    private int cartId;
    
    private User user;

    private List<CartItem> cartItems;
    
    
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    // Add a new item to the cart
    public void addItem(CartItem item) {
        this.cartItems.add(item);
    }

    // Remove an item from the cart
    public void removeItem(CartItem item) {
        this.cartItems.remove(item);
    }
    public boolean removeById(int cartItemId) {
        return cartItems.removeIf(cartItem -> cartItem.getCartItemId() == cartItemId);
    }

}

