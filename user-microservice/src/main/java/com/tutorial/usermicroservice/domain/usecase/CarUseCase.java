package com.tutorial.usermicroservice.domain.usecase;

import com.tutorial.usermicroservice.domain.api.ICarServicePort;
import com.tutorial.usermicroservice.domain.model.Car;
import com.tutorial.usermicroservice.domain.spi.ICarPersistencePort;

import java.util.List;

public class CarUseCase implements ICarServicePort {
    private final ICarPersistencePort carPersistencePort;

    public CarUseCase(ICarPersistencePort carPersistencePort) {
        this.carPersistencePort = carPersistencePort;
    }

    @Override
    public List<Car> getAllCarsByUserId(Long userId) {
        return carPersistencePort.getAllCarsByUserId(userId);
    }

    @Override
    public void saveCar(Car car) {
        carPersistencePort.saveCar(car);
    }
}
