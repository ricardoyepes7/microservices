package com.tutorial.carmicroservice.infrastructure.output.jpa.adapter;

import com.tutorial.carmicroservice.domain.exception.CarException;
import com.tutorial.carmicroservice.domain.model.Car;
import com.tutorial.carmicroservice.domain.spi.ICarPersistencePort;
import com.tutorial.carmicroservice.infrastructure.output.jpa.mapper.ICarEntityMapper;
import com.tutorial.carmicroservice.infrastructure.output.jpa.repository.ICarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@RequiredArgsConstructor
public class CarJpaAdapter implements ICarPersistencePort {
    private final ICarRepository carRepository;
    private final ICarEntityMapper carEntityMapper;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(carEntityMapper::toModel)
                .toList();
    }

    @Override
    public List<Car> getAllUserCarsByUserId(Long userId) {
        return carRepository.findByUserId(userId)
                .stream()
                .map(carEntityMapper::toModel)
                .toList();
    }

    @Override
    public Car getCarByCarId(Long carId) {
        return carRepository.findById(carId)
                .map(carEntityMapper::toModel)
                .orElseThrow(() -> new CarException("Car Not Found.",
                        "Carro con id: " + carId + " no encontrado.",
                        HttpStatus.NOT_FOUND));
    }

    @Override
    public void saveCar(Car car) {
        carRepository.save(carEntityMapper.toEntity(car));
    }
}
