package com.kafka.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String productName;
    private String competetiorName;
    private Double conversionFactor;

    public Product(Integer id, String productName, String competetiorName, Double conversionFactor) {
        this.id = id;
        this.productName = productName;
        this.competetiorName = competetiorName;
        this.conversionFactor = conversionFactor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCompetetiorName() {
        return competetiorName;
    }

    public void setCompetetiorName(String competetiorName) {
        this.competetiorName = competetiorName;
    }

    public Double getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(Double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", competetiorName='" + competetiorName + '\'' +
                ", conversionFactor=" + conversionFactor +
                '}';
    }
}
