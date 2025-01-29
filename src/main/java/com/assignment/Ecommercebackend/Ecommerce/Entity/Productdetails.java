package com.assignment.Ecommercebackend.Ecommerce.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="productdetails")
public class Productdetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="product_ID",nullable = false)
    private int id;

    @OneToOne
    @JoinColumn(name = "product_ID", referencedColumnName = "product_ID", insertable = false, updatable = false)
    private Product product;

    @Column(name="productmaterial",length = 256,nullable = false)
    private String material;

    @Column(name="productadjective",length = 256,nullable = false)
    private String adjective;


    public Productdetails(int id, Product product, String adjective, String material) {
        this.id = id;
        this.product = product;
        this.adjective = adjective;
        this.material = material;
    }

    public Productdetails() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdjective() {
        return adjective;
    }

    public void setAdjective(String adjective) {
        this.adjective = adjective;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
