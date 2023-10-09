package com.tutorial.usermicroservice.application.handler.interfaces;

import com.tutorial.usermicroservice.application.dto.CarDto;

import java.util.List;

public interface ICarHandler {
    List<CarDto> getAllCarsByUserId(Long userId);
    void saveUserCar(CarDto carDto,Long userId);
}
