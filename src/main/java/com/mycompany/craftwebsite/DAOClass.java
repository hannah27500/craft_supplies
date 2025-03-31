package com.mycompany.craftwebsite;

import com.mycompany.craftwebsite.business.Orders;
import com.mycompany.craftwebsite.business.Product;
import jakarta.persistence.EntityManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOClass {
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM product";

        try (Connection connection = DBUtil.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                productList.add(new Product(
                    rs.getInt("productID"),
                    rs.getString("productName"),
                    rs.getString("productDesc"),
                    rs.getDouble("price"),
                    rs.getString("category"),
                    rs.getInt("stockQuantity")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
  public static Product getProductByID(int productID) {
        Product product = null;
        try (Connection conn = DBUtil.getConnection()) {
            String query = "SELECT * FROM product WHERE productID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, productID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                product = new Product(
                    rs.getInt("productID"),
                    rs.getString("productName"),
                    rs.getString("productDesc"),
                    rs.getDouble("price"),
                    rs.getString("category"),
                    rs.getInt("stockQuantity")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
  
  public static List<Orders> getOrdersByUser(int userID) throws SQLException {
        List<Orders> orderList = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE userID = ? ORDER BY orderDate DESC";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Orders order = new Orders(
                        rs.getInt("orderID"),
                        rs.getInt("userID"),
                        rs.getDouble("totalPrice"),
                        rs.getTimestamp("orderDate")
                );
                orderList.add(order);
            }
        }
        return orderList;
    }
  public static void updateProductQuantity(int productId, int quantityOrdered) {
    String sql = "UPDATE product SET stockQuantity = stockQuantity - ? WHERE productID = ?";
    
    try (Connection conn = DBUtil.getConnection(); // Get DB connection
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, quantityOrdered);
        stmt.setInt(2, productId);
        
        int rowsUpdated = stmt.executeUpdate();
        
        if (rowsUpdated > 0) {
            System.out.println("Product quantity updated successfully.");
        } else {
            System.out.println("Error: Product not found or stock insufficient.");
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
  
}
