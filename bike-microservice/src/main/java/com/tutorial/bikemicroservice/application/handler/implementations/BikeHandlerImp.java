package com.tutorial.bikemicroservice.application.handler.implementations;

import com.tutorial.bikemicroservice.application.dto.BikeDto;
import com.tutorial.bikemicroservice.application.handler.interfaces.IBikeHandler;
import com.tutorial.bikemicroservice.application.mapper.IBikeDtoMapper;
import com.tutorial.bikemicroservice.domain.api.IBikeServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BikeHandlerImp implements IBikeHandler {
    private final IBikeServicePort bikeServicePort;
    private final IBikeDtoMapper bikeDtoMapper;

    @Override
    public List<BikeDto> getAllBikes() {
        return bikeServicePort.getAllBikes()
                .stream()
                .map(bikeDtoMapper::toDto)
                .toList();
    }

    @Override
    public List<BikeDto> getUserBikesByUserId(Long userId) {
        return bikeServicePort.getUserBikesByUserId(userId)
                .stream()
                .map(bikeDtoMapper::toDto)
                .toList();
    }

    @Override
    public BikeDto getBikeByBikeId(Long bikeId) {
        return bikeDtoMapper.toDto(bikeServicePort.getBikeByBikeId(bikeId));
    }

    @Override
    public void saveBike(BikeDto bikeDto) {
        bikeServicePort.saveBike(bikeDtoMapper.toModel(bikeDto));
    }
}
