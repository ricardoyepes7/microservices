package com.tutorial.bikemicroservice.domain.api;

import com.tutorial.bikemicroservice.domain.model.Bike;

import java.util.List;

public interface IBikeServicePort {
    List<Bike> getAllBikes();
    List<Bike> getUserBikesByUserId(Long userId);
    Bike getBikeByBikeId(Long bikeId);
    void saveBike(Bike bike);
}
