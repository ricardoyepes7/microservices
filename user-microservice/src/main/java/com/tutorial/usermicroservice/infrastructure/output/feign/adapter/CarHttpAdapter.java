package com.tutorial.usermicroservice.infrastructure.output.feign.adapter;

import com.tutorial.usermicroservice.domain.model.Car;
import com.tutorial.usermicroservice.domain.spi.ICarPersistencePort;
import com.tutorial.usermicroservice.infrastructure.output.feign.httpclient.ICarFeignClient;
import com.tutorial.usermicroservice.infrastructure.output.feign.mapper.ICarHttpMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CarHttpAdapter implements ICarPersistencePort {
    private final ICarFeignClient carFeignClient;
    private final ICarHttpMapper carHttpMapper;

    @Override
    public List<Car> getAllCarsByUserId(Long userId) {
        return carFeignClient.getCarsByUserId(userId)
                .stream()
                .map(carHttpMapper::toModel)
                .toList();
    }

    @Override
    public void saveCar(Car car) {
        carFeignClient.saveCar(carHttpMapper.toHttpClient(car));
    }
}
