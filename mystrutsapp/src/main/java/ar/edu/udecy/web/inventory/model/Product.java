package ar.edu.udecy.web.inventory.model;

import java.math.BigDecimal;

public class Product {
    private String productId;
    private String productName;
    private String sku;
    private String unitOfMeasure;
    private BigDecimal cost;
    private BigDecimal salePrice;
    private String category;
    private String location;
    private boolean active;

    // Constructor vacío
    public Product() {
    }

    // Constructor con todos los campos
    public Product(String productId, String productName, String sku, String unitOfMeasure,
                   BigDecimal cost, BigDecimal salePrice, String category, String location, boolean active) {
        this.productId = productId;
        this.productName = productName;
        this.sku = sku;
        this.unitOfMeasure = unitOfMeasure;
        this.cost = cost;
        this.salePrice = salePrice;
        this.category = category;
        this.location = location;
        this.active = active;
    }

    // Getters y Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", sku='" + sku + '\'' +
                ", unitOfMeasure='" + unitOfMeasure + '\'' +
                ", cost=" + cost +
                ", salePrice=" + salePrice +
                ", category='" + category + '\'' +
                ", location='" + location + '\'' +
                ", active=" + active +
                '}';
    }
}