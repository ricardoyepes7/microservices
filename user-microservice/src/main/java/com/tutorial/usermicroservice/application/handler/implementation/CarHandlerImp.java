package com.tutorial.usermicroservice.application.handler.implementation;

import com.tutorial.usermicroservice.application.dto.CarDto;
import com.tutorial.usermicroservice.application.handler.interfaces.ICarHandler;
import com.tutorial.usermicroservice.application.mapper.ICarDtoMapper;
import com.tutorial.usermicroservice.domain.api.ICarServicePort;
import com.tutorial.usermicroservice.domain.model.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarHandlerImp implements ICarHandler {
    private final ICarServicePort carServicePort;
    private final ICarDtoMapper carDtoMapper;

    @Override
    public List<CarDto> getAllCarsByUserId(Long userId) {
        return carServicePort.getAllCarsByUserId(userId)
                .stream()
                .map(carDtoMapper::toDto)
                .toList();
    }

    @Override
    public void saveUserCar(CarDto carDto, Long userId) {
        Car car = carDtoMapper.toModel(carDto);
        car.setUserId(userId);
        carServicePort.saveCar(car);
    }
}
