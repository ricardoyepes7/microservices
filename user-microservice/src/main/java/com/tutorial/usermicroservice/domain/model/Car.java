package com.tutorial.usermicroservice.domain.model;

public class Car {
    private String brand;
    private String model;
    private Long userId;

    public Car(String brand, String model, Long userId) {
        this.brand = brand;
        this.model = model;
        this.userId = userId;
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
