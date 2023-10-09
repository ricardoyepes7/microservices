package com.tutorial.carmicroservice.application.handler.implementations;

import com.tutorial.carmicroservice.application.dto.CarDto;
import com.tutorial.carmicroservice.application.handler.interfaces.ICarHandler;
import com.tutorial.carmicroservice.application.mapper.ICarDtoMapper;
import com.tutorial.carmicroservice.domain.api.ICarServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarHandlerImp implements ICarHandler {
    public final ICarServicePort carServicePort;
    public final ICarDtoMapper carDtoMapper;

    @Override
    public CarDto getCarByCarId(Long carId) {
        return carDtoMapper.toDto(carServicePort.getCarByCarId(carId));
    }

    @Override
    public List<CarDto> getAllUserCars(Long userId) {
        return carServicePort.getAllUserCarsByUserId(userId)
                .stream()
                .map(carDtoMapper::toDto)
                .toList();
    }

    @Override
    public void saveCar(CarDto carDto) {
        carServicePort.saveCar(carDtoMapper.toModel(carDto));
    }
}
