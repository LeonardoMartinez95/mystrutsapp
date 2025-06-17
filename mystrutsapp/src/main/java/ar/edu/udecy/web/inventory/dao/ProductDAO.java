package ar.edu.udecy.web.inventory.dao;



import ar.edu.udecy.web.inventory.model.Product;
import ar.edu.udecy.web.inventory.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class ProductDAO {

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT product_id, product_name, sku, unit_of_measure, cost, sale_price, category, location, active FROM ProductMasterData";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setSku(rs.getString("sku"));
                product.setUnitOfMeasure(rs.getString("unit_of_measure"));
                product.setCost(rs.getBigDecimal("cost"));
                product.setSalePrice(rs.getBigDecimal("sale_price"));
                product.setCategory(rs.getString("category"));
                product.setLocation(rs.getString("location"));
                product.setActive(rs.getBoolean("active"));
                products.add(product);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching all products: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                DBConnection.closeConnection(conn);
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return products;
    }

    public Product getProductById(String productId) {
        Product product = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT product_id, product_name, sku, unit_of_measure, cost, sale_price, category, location, active FROM ProductMasterData WHERE product_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, productId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                product = new Product();
                product.setProductId(rs.getString("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setSku(rs.getString("sku"));
                product.setUnitOfMeasure(rs.getString("unit_of_measure"));
                product.setCost(rs.getBigDecimal("cost"));
                product.setSalePrice(rs.getBigDecimal("sale_price"));
                product.setCategory(rs.getString("category"));
                product.setLocation(rs.getString("location"));
                product.setActive(rs.getBoolean("active"));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching product by ID: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                DBConnection.closeConnection(conn);
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return product;
    }

    public boolean addProduct(Product product) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "INSERT INTO ProductMasterData (product_id, product_name, sku, unit_of_measure, cost, sale_price, category, location, active) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, product.getProductId());
            pstmt.setString(2, product.getProductName());
            pstmt.setString(3, product.getSku());
            pstmt.setString(4, product.getUnitOfMeasure());
            pstmt.setBigDecimal(5, product.getCost());
            pstmt.setBigDecimal(6, product.getSalePrice());
            pstmt.setString(7, product.getCategory());
            pstmt.setString(8, product.getLocation());
            pstmt.setBoolean(9, product.isActive());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error adding product: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                DBConnection.closeConnection(conn);
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public boolean updateProduct(Product product) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "UPDATE ProductMasterData SET product_name = ?, sku = ?, unit_of_measure = ?, cost = ?, sale_price = ?, category = ?, location = ?, active = ? WHERE product_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, product.getProductName());
            pstmt.setString(2, product.getSku());
            pstmt.setString(3, product.getUnitOfMeasure());
            pstmt.setBigDecimal(4, product.getCost());
            pstmt.setBigDecimal(5, product.getSalePrice());
            pstmt.setString(6, product.getCategory());
            pstmt.setString(7, product.getLocation());
            pstmt.setBoolean(8, product.isActive());
            pstmt.setString(9, product.getProductId());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error updating product: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                DBConnection.closeConnection(conn);
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public boolean deleteProduct(String productId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "DELETE FROM ProductMasterData WHERE product_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, productId);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting product: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                DBConnection.closeConnection(conn);
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
