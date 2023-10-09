package com.tutorial.bikemicroservice.application.handler.interfaces;

import com.tutorial.bikemicroservice.application.dto.BikeDto;

import java.util.List;

public interface IBikeHandler {
    List<BikeDto> getAllBikes();
    List<BikeDto> getUserBikesByUserId(Long userId);
    BikeDto getBikeByBikeId(Long bikeId);
    void saveBike(BikeDto bikeDto);
}
