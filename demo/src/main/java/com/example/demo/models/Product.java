package com.example.demo.models;

import jakarta.persistence.*;

import java.util.Objects;

//POJO Plan object java object
@Entity
@Table(name="tblProduct")
public class Product {
    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;
    // validate
    @Column(nullable = false,unique = true, length = 255)
    private String productName;
    @Column(name="_year")
    private int year;
    private Double price;
    private String url;
    public Product(){};
//    @Transient
    public Product(String productName, int year, Double price, String url) {
        this.productName = productName;
        this.year = year;
        this.price = price;
        this.url = url;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long idProduct) {
        this.id = idProduct;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return year == product.year && Objects.equals(id, product.id) && Objects.equals(productName, product.productName) && Objects.equals(price, product.price) && Objects.equals(url, product.url);
    }
}
