package ar.edu.udecy.web.inventory.model;

import java.sql.Timestamp;

public class InventoryMovement {
    private String movementId;
    private Timestamp date;
    private String productId;
    private String movementType;
    private int quantity;
    private String orderId;
    private String notes;

    public InventoryMovement() {
    }

    public InventoryMovement(String movementId, Timestamp date, String productId, String movementType,
                             int quantity, String orderId, String notes) {
        this.movementId = movementId;
        this.date = date;
        this.productId = productId;
        this.movementType = movementType;
        this.quantity = quantity;
        this.orderId = orderId;
        this.notes = notes;
    }

    // Getters y Setters
    public String getMovementId() {
        return movementId;
    }

    public void setMovementId(String movementId) {
        this.movementId = movementId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMovementType() {
        return movementType;
    }

    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "InventoryMovement{" +
                "movementId='" + movementId + '\'' +
                ", date=" + date +
                ", productId='" + productId + '\'' +
                ", movementType='" + movementType + '\'' +
                ", quantity=" + quantity +
                ", orderId='" + orderId + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
