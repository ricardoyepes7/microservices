package com.tutorial.carmicroservice.domain.api;

import com.tutorial.carmicroservice.domain.model.Car;

import java.util.List;

public interface ICarServicePort {
    List<Car> getAllCars();
    List<Car> getAllUserCarsByUserId(Long userId);
    Car getCarByCarId(Long carId);
    void saveCar(Car car);
}
