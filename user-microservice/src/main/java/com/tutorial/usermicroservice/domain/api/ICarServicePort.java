package com.tutorial.usermicroservice.domain.api;

import com.tutorial.usermicroservice.domain.model.Car;

import java.util.List;

public interface ICarServicePort {
    List<Car> getAllCarsByUserId(Long userId);
    void saveCar(Car car);
}
