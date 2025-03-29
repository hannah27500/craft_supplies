/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.craftwebsite.login;

import com.mycompany.craftwebsite.DBUtil;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author ccdev
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

          try (Connection con = DBUtil.getConnection()) {
            
            String query = "SELECT * FROM user WHERE username = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, username);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                // User found, now check password (consider hashing if needed)
                String storedPassword = rs.getString("password"); // The password stored in the database
                
                // Check if the provided password matches (in a real application, hash the password)
                if (password.equals(storedPassword)) {
                    // Correct credentials
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username); // Store username in session
                    String storedFirstName = rs.getString("firstName");
                    String storedLastName = rs.getString("lastName");
                    String storedUserId = rs.getString("userId");
                    session.setAttribute("firstName", storedFirstName);
                     session.setAttribute("lastName", storedLastName);
                     session.setAttribute("userId", storedUserId);
                    
                    // Redirect to home page or user profile
                    response.sendRedirect("home.jsp");
                } else {
                    // Incorrect password
                    response.sendRedirect("index.jsp?error=InvalidCredentials");
                }
            } else {
                // User not found
                response.sendRedirect("index.jsp?error=UserNotFound");
            }
        } catch (SQLException e) {
            // Handle database errors
            e.printStackTrace();
            response.sendRedirect("index.jsp?error=DatabaseError");
        }
    }

 

}
