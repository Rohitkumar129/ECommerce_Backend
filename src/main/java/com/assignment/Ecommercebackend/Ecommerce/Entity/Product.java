package com.assignment.Ecommercebackend.Ecommerce.Entity;
import jakarta.persistence.*;


@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="product_ID",nullable = false)
    private int product_ID;

    @Column(name="product_name",nullable = false,length = 256)
    private String name;

    @Lob
    @Column(name="product_img",length = 256, nullable = false)
    private String image;

    @Column(name="product_description",nullable = false,length = 1024)
    private String description;

    @Column(name="product_price")
    private float price;

    @Column(name="rating",nullable = false)
    private int rating;
    public Product(int product_ID, String name, String image, String description, float price,int rating) {
        this.product_ID = product_ID;
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
        this.rating=rating;
    }

    public Product() {
    }

    public int getProduct_ID() {
        return product_ID;
    }

    public void setProduct_ID(int product_ID) {
        this.product_ID = product_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

