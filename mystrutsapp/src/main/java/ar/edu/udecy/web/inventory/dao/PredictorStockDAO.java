package ar.edu.udecy.web.inventory.dao;


import ar.edu.udecy.web.inventory.model.PredictorStock;
import ar.edu.udecy.web.inventory.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class PredictorStockDAO {

    public List<PredictorStock> getAllPredictorStockData() {
        List<PredictorStock> data = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT date, product_id, units_sold, avg_sale_price, promotion_active, special_event FROM PredictorStock";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                PredictorStock ps = new PredictorStock();
                ps.setDate(rs.getDate("date"));
                ps.setProductId(rs.getString("product_id"));
                ps.setUnitsSold(rs.getInt("units_sold"));
                ps.setAvgSalePrice(rs.getBigDecimal("avg_sale_price"));
                ps.setPromotionActive(rs.getBoolean("promotion_active"));
                ps.setSpecialEvent(rs.getString("special_event"));
                data.add(ps);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching all predictor stock data: " + e.getMessage());
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
        return data;
    }

    // ... otros métodos CRUD para PredictorStock
}