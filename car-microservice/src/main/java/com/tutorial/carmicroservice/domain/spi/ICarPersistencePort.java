package com.tutorial.carmicroservice.domain.spi;

import com.tutorial.carmicroservice.domain.model.Car;

import java.util.List;

public interface ICarPersistencePort {
    List<Car> getAllCars();
    List<Car> getAllUserCarsByUserId(Long userId);
    Car getCarByCarId(Long carId);
    void saveCar(Car car);
}
