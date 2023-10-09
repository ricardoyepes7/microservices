package com.tutorial.carmicroservice.domain.usecase;

import com.tutorial.carmicroservice.domain.api.ICarServicePort;
import com.tutorial.carmicroservice.domain.model.Car;
import com.tutorial.carmicroservice.domain.spi.ICarPersistencePort;

import java.util.List;

public class CarUseCase implements ICarServicePort {
    public final ICarPersistencePort carPersistencePort;

    public CarUseCase(ICarPersistencePort carPersistencePort) {
        this.carPersistencePort = carPersistencePort;
    }

    @Override
    public List<Car> getAllCars() {
        return carPersistencePort.getAllCars();
    }

    @Override
    public List<Car> getAllUserCarsByUserId(Long userId) {
        return carPersistencePort.getAllUserCarsByUserId(userId);
    }

    @Override
    public Car getCarByCarId(Long carId) {
        return carPersistencePort.getCarByCarId(carId);
    }

    @Override
    public void saveCar(Car car) {
        carPersistencePort.saveCar(car);
    }
}
