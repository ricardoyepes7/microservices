package com.tutorial.usermicroservice.domain.spi;

import com.tutorial.usermicroservice.domain.model.Car;

import java.util.List;

public interface ICarPersistencePort {
    List<Car> getAllCarsByUserId(Long userId);
    void saveCar(Car car);
}
