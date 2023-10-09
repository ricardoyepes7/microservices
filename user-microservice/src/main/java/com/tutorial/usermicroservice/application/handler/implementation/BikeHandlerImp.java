package com.tutorial.usermicroservice.application.handler.implementation;

import com.tutorial.usermicroservice.application.dto.BikeDto;
import com.tutorial.usermicroservice.application.handler.interfaces.IBikeHandler;
import com.tutorial.usermicroservice.application.mapper.IBikeDtoMapper;
import com.tutorial.usermicroservice.domain.api.IBikeServicePort;
import com.tutorial.usermicroservice.domain.model.Bike;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BikeHandlerImp implements IBikeHandler {
    private final IBikeServicePort bikeServicePort;
    private final IBikeDtoMapper bikeDtoMapper;

    @Override
    public List<BikeDto> getAllBikesByUserId(Long userId) {
        return bikeServicePort.getAllBikesByUserId(userId)
                .stream()
                .map(bikeDtoMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public void saveUserBike(BikeDto bikeDto, Long userId) {
        Bike bike = bikeDtoMapper.toModel(bikeDto);
        bike.setUserId(userId);
        bikeServicePort.saveBike(bike);
    }
}
