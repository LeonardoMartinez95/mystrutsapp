package ar.edu.udecy.web.inventory.model;

import java.math.BigDecimal;
import java.sql.Date;

public class PredictorStock {
    private Date date;
    private String productId;
    private int unitsSold;
    private BigDecimal avgSalePrice;
    private boolean promotionActive;
    private String specialEvent;

    public PredictorStock() {
    }

    public PredictorStock(Date date, String productId, int unitsSold, BigDecimal avgSalePrice,
                          boolean promotionActive, String specialEvent) {
        this.date = date;
        this.productId = productId;
        this.unitsSold = unitsSold;
        this.avgSalePrice = avgSalePrice;
        this.promotionActive = promotionActive;
        this.specialEvent = specialEvent;
    }

    // Getters y Setters
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(int unitsSold) {
        this.unitsSold = unitsSold;
    }

    public BigDecimal getAvgSalePrice() {
        return avgSalePrice;
    }

    public void setAvgSalePrice(BigDecimal avgSalePrice) {
        this.avgSalePrice = avgSalePrice;
    }

    public boolean isPromotionActive() {
        return promotionActive;
    }

    public void setPromotionActive(boolean promotionActive) {
        this.promotionActive = promotionActive;
    }

    public String getSpecialEvent() {
        return specialEvent;
    }

    public void setSpecialEvent(String specialEvent) {
        this.specialEvent = specialEvent;
    }

    @Override
    public String toString() {
        return "PredictorStock{" +
                "date=" + date +
                ", productId='" + productId + '\'' +
                ", unitsSold=" + unitsSold +
                ", avgSalePrice=" + avgSalePrice +
                ", promotionActive=" + promotionActive +
                ", specialEvent='" + specialEvent + '\'' +
                '}';
    }
}
