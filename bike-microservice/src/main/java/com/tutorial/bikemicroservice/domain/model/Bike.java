package com.tutorial.bikemicroservice.domain.model;

public class Bike {
    private Long id;
    private String brand;
    private String model;
    private Long userId;

    public Bike(Long id, String brand, String model, Long userId) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
