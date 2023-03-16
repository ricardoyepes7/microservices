package com.tutorial.carmicroservice.service;

import com.tutorial.carmicroservice.entity.Car;
import com.tutorial.carmicroservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAll(){
        return carRepository.findAll();
    }

    public Optional<Car> getUserById(long id){
        return carRepository.findById(id);
    }

    public Car save(Car car){
        return carRepository.save(car);
    }

    public List<Car> getByUserId(long userId){
        return carRepository.findByUserId(userId);
    }
}
