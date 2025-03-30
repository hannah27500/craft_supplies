/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.craftwebsite.servlets;

import com.mycompany.craftwebsite.DAOClass;
import com.mycompany.craftwebsite.business.CartItem;
import com.mycompany.craftwebsite.business.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          String action = request.getParameter("action");
        HttpSession session = request.getSession();

        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        if ("add".equals(action)) {
            int productId = Integer.parseInt(request.getParameter("productID"));
            Product product = getProductById(productId);
           
            // Check if the product is already in the cart
            boolean found = false;
            for (CartItem item : cart) {
                if (item.getProductId() == productId) {
                    item.increaseQuantity();  
                    found = true;
                    break;
                }
            }
            if (!found) {
                cart.add(new CartItem(product));  // Add new CartItem if not found
            }
        } else if ("remove".equals(action)) {
            int productId = Integer.parseInt(request.getParameter("cartItemID"));
            for (Iterator<CartItem> iterator = cart.iterator(); iterator.hasNext();) {
                CartItem item = iterator.next();
                if (item.getProductId()  == productId) {
                    iterator.remove();  // Remove product from cart
                    break;
                }
            }
        }
        

        response.sendRedirect("cart.jsp");
    }

    private Product getProductById(int productId) {
        Product product = DAOClass.getProductByID(productId);
        return product;
    }
}
