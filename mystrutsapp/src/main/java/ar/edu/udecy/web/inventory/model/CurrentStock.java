package ar.edu.udecy.web.inventory.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class CurrentStock {
    private String productId;
    private int quantity;
    private Timestamp lastUpdated;
    private BigDecimal totalInventoryCost;

    public CurrentStock() {
    }

    public CurrentStock(String productId, int quantity, Timestamp lastUpdated, BigDecimal totalInventoryCost) {
        this.productId = productId;
        this.quantity = quantity;
        this.lastUpdated = lastUpdated;
        this.totalInventoryCost = totalInventoryCost;
    }

    // Getters y Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public BigDecimal getTotalInventoryCost() {
        return totalInventoryCost;
    }

    public void setTotalInventoryCost(BigDecimal totalInventoryCost) {
        this.totalInventoryCost = totalInventoryCost;
    }

    @Override
    public String toString() {
        return "CurrentStock{" +
                "productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", lastUpdated=" + lastUpdated +
                ", totalInventoryCost=" + totalInventoryCost +
                '}';
    }
}
