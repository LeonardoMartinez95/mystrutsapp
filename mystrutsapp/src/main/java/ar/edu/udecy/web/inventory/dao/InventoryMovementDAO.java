package ar.edu.udecy.web.inventory.dao;

import ar.edu.udecy.web.inventory.model.InventoryMovement;
import ar.edu.udecy.web.inventory.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryMovementDAO {

    public List<InventoryMovement> getAllInventoryMovements() {
        List<InventoryMovement> movements = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT movement_id, date, product_id, movement_type, quantity, order_id, notes FROM InventoryMovementData";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                InventoryMovement movement = new InventoryMovement();
                movement.setMovementId(rs.getString("movement_id"));
                movement.setDate(rs.getTimestamp("date"));
                movement.setProductId(rs.getString("product_id"));
                movement.setMovementType(rs.getString("movement_type"));
                movement.setQuantity(rs.getInt("quantity"));
                movement.setOrderId(rs.getString("order_id"));
                movement.setNotes(rs.getString("notes"));
                movements.add(movement);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching all inventory movements: " + e.getMessage());
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
        return movements;
    }

    public boolean addInventoryMovement(InventoryMovement movement) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "INSERT INTO InventoryMovementData (movement_id, date, product_id, movement_type, quantity, order_id, notes) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, movement.getMovementId());
            pstmt.setTimestamp(2, movement.getDate());
            pstmt.setString(3, movement.getProductId());
            pstmt.setString(4, movement.getMovementType());
            pstmt.setInt(5, movement.getQuantity());
            pstmt.setString(6, movement.getOrderId());
            pstmt.setString(7, movement.getNotes());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error adding inventory movement: " + e.getMessage());
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

    // ... otros métodos CRUD (update, delete, getById) para InventoryMovement
}
