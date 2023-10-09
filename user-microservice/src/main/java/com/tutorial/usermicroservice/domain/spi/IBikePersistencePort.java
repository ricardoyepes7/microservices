package com.tutorial.usermicroservice.domain.spi;

import com.tutorial.usermicroservice.domain.model.Bike;

import java.util.List;

public interface IBikePersistencePort {
    List<Bike> getAllBikesByUserId(Long userId);

    void saveBike(Bike bike);
}
