package com.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="product_model")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelName;

    @ManyToMany(mappedBy = "models")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Product> products = new HashSet<>();

    public ProductModel() {}
    public ProductModel(String modelName) { this.modelName = modelName; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getModelName() { return modelName; }
    public void setModelName(String modelName) { this.modelName = modelName; }
    public Set<Product> getProducts() { return products; }
    public void setProducts(Set<Product> products) { this.products = products; }

    @Override
    public String toString() {
        return "ProductModel{id=" + id + ", modelName='" + modelName + "'}";
    }
}
