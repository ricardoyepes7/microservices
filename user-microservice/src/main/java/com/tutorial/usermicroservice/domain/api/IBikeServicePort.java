package com.tutorial.usermicroservice.domain.api;

import com.tutorial.usermicroservice.domain.model.Bike;

import java.util.List;

public interface IBikeServicePort {
    List<Bike> getAllBikesByUserId(Long userId);

    void saveBike(Bike bike);
}
