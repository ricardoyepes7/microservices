package com.tutorial.usermicroservice.infrastructure.output.feign.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto{
        private String brand;
        private String model;
        private Long userId;
}
