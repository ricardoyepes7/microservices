package com.tutorial.usermicroservice.infrastructure.output.feign.adapter;

import com.tutorial.usermicroservice.domain.model.Bike;
import com.tutorial.usermicroservice.domain.spi.IBikePersistencePort;
import com.tutorial.usermicroservice.infrastructure.output.feign.httpclient.IBikeFeignClient;
import com.tutorial.usermicroservice.infrastructure.output.feign.mapper.IBikeHttpMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BikeHttpAdapter implements IBikePersistencePort {
    private final IBikeFeignClient bikeFeignClient;
    private final IBikeHttpMapper bikeHttpMapper;

    @Override
    public List<Bike> getAllBikesByUserId(Long userId) {
        return bikeFeignClient.getBikesByUserId(userId)
                .stream()
                .map(bikeHttpMapper::toModel)
                .toList();
    }

    @Override
    public void saveBike(Bike bike) {
        bikeFeignClient.saveBike(bikeHttpMapper.toHttpClient(bike));
    }
}
