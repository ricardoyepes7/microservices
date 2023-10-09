package com.tutorial.usermicroservice.application.handler.interfaces;

import com.tutorial.usermicroservice.application.dto.BikeDto;

import java.util.List;

public interface IBikeHandler {
    List<BikeDto> getAllBikesByUserId(Long userId);
    void saveUserBike(BikeDto bikeDto,Long userId);
}
