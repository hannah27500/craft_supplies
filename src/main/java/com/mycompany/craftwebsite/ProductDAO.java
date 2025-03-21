package com.mycompany.craftwebsite;

import com.mycompany.craftwebsite.business.Product;
import jakarta.persistence.EntityManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
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
  
}
