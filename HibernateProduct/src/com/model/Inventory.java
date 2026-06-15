package com.model;

import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "inventory")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;
    private int productAmount;
    private String category;
    private String productModel;

    public Inventory() {}
    public Inventory(String productName, int productAmount, String category, String productModel) {
        this.productName = productName;
        this.productAmount = productAmount;
        this.category = category;
        this.productModel = productModel;
    }

    // getters and setters
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public int getProductAmount() { return productAmount; }
    public void setProductAmount(int productAmount) { this.productAmount = productAmount; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getProductModel() { return productModel; }
    public void setProductModel(String productModel) { this.productModel = productModel; }

    @Override
    public String toString() {
        return "Inventory{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productAmount=" + productAmount +
                ", category='" + category + '\'' +
                ", productModel='" + productModel + '\'' +
                '}';
    }
}
