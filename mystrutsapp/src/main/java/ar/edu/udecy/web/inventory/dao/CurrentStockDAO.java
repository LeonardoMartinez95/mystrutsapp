package ar.edu.udecy.web.inventory.dao;

import ar.edu.udecy.web.inventory.model.CurrentStock;
import ar.edu.udecy.web.inventory.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CurrentStockDAO {

    public List<CurrentStock> getAllCurrentStock() {
        List<CurrentStock> stocks = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT product_id, quantity, last_updated, total_inventory_cost FROM CurrentStockData";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                CurrentStock stock = new CurrentStock();
                stock.setProductId(rs.getString("product_id"));
                stock.setQuantity(rs.getInt("quantity"));
                stock.setLastUpdated(rs.getTimestamp("last_updated"));
                stock.setTotalInventoryCost(rs.getBigDecimal("total_inventory_cost"));
                stocks.add(stock);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching all current stock: " + e.getMessage());
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
        return stocks;
    }

    public CurrentStock getCurrentStockByProductId(String productId) {
        CurrentStock stock = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT product_id, quantity, last_updated, total_inventory_cost FROM CurrentStockData WHERE product_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, productId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                stock = new CurrentStock();
                stock.setProductId(rs.getString("product_id"));
                stock.setQuantity(rs.getInt("quantity"));
                stock.setLastUpdated(rs.getTimestamp("last_updated"));
                stock.setTotalInventoryCost(rs.getBigDecimal("total_inventory_cost"));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching current stock by product ID: " + e.getMessage());
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
        return stock;
    }

    // ... otros métodos CRUD (update, delete, add) para CurrentStock
}