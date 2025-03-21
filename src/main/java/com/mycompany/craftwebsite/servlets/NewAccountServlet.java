/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.craftwebsite.servlets;

import com.mycompany.craftwebsite.DBUtil;
import com.mycompany.craftwebsite.business.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ccdev
 */
@WebServlet(name = "NewAccountServlet", urlPatterns = {"/NewAccountServlet"})
public class NewAccountServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String newUsername = request.getParameter("newUsername");
        String newPassword = request.getParameter("newPassword");
        
        User newUser = new User(firstName, lastName, newUsername, newPassword);

        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO user (firstName,lastName,username, password) VALUES (?, ?,?,?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, firstName);
                stmt.setString(2, lastName);
                stmt.setString(3, newUsername);
                stmt.setString(4, newPassword);
                       // Execute the update
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                  
                    HttpSession session = request.getSession();
                    session.setAttribute("username", newUsername); // Store username in session
                    // Redirect to login page after successful registration
                    response.sendRedirect("home.jsp");
                } else {
                    response.getWriter().println("Error: Could not create account.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
