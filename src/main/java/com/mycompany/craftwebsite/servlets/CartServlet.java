/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.craftwebsite.servlets;

import com.mycompany.craftwebsite.ProductDAO;
import com.mycompany.craftwebsite.business.Cart;
import com.mycompany.craftwebsite.business.CartItem;
import com.mycompany.craftwebsite.business.Product;
import static com.mysql.cj.conf.PropertyKey.logger;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Product> cart = (List<Product>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        request.setAttribute("cart", cart);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the CartItemId of the item to be removed from the request
        int cartItemID = Integer.parseInt(request.getParameter("cartItemID"));
        String cartItemIDParam = request.getParameter("cartItemID");

   if (cartItemIDParam == null || cartItemIDParam.isEmpty()) {
     
       response.sendRedirect("cart.jsp?error=Missing cart item ID");
       
    
    return;
} else {
  System.out.println("Success");
}

        // Get the current session and the Cart
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart != null) {
            // Try to remove the item by its CartItemId
            boolean removed = cart.removeById(cartItemID);

            if (removed) {
                // Successfully removed, update the session with the new cart
                session.setAttribute("cart", cart);
            }
        }

        // Redirect to the cart page or wherever you want the user to go after removal
        response.sendRedirect("cart.jsp");
    }
}