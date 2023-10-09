package com.tutorial.bikemicroservice.application.dto;

import lombok.Data;

@Data
public class BikeDto {
    private String brand;
    private String model;
    private Long userId;
}
