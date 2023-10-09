package com.tutorial.carmicroservice.application.handler.interfaces;

import com.tutorial.carmicroservice.application.dto.CarDto;

import java.util.List;

public interface ICarHandler {
    CarDto getCarByCarId(Long carId);
    List<CarDto> getAllUserCars(Long userId);
    void saveCar(CarDto carDto);
}
