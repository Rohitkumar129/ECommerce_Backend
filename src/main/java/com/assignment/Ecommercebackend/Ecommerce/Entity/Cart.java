package com.assignment.Ecommercebackend.Ecommerce.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="cart")
public class Cart {
    @Id
   // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="product_ID",nullable = false)
    private int id;

    @OneToOne
    @JoinColumn(name = "product_ID", referencedColumnName = "product_ID")
    private Product product;
    @Column(name="Bought_quantity",nullable = false)
    private int quantity;

    public Cart(int id, int quantity) {
        this.id = id;
        //this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
