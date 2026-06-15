package com.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="product")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_productmodel",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "productmodel_id"))
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<ProductModel> models = new HashSet<>();

    public Product() {}
    public Product(String name) { this.name = name; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Set<ProductModel> getModels() { return models; }
    public void setModels(Set<ProductModel> models) { this.models = models; }

    public void addModel(ProductModel m) {
        models.add(m);
        m.getProducts().add(this);
    }
    public void removeModel(ProductModel m) {
        models.remove(m);
        m.getProducts().remove(this);
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "'}";
    }
}
