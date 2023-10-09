package com.tutorial.bikemicroservice.domain.usecase;

import com.tutorial.bikemicroservice.domain.api.IBikeServicePort;
import com.tutorial.bikemicroservice.domain.model.Bike;
import com.tutorial.bikemicroservice.domain.spi.IBikePersistencePort;

import java.util.List;

public class BikeUseCase implements IBikeServicePort {
    private final IBikePersistencePort bikePersistencePort;

    public BikeUseCase(IBikePersistencePort bikePersistencePort) {
        this.bikePersistencePort = bikePersistencePort;
    }

    @Override
    public List<Bike> getAllBikes() {
        return bikePersistencePort.getAllBikes();
    }

    @Override
    public List<Bike> getUserBikesByUserId(Long userId) {
        return bikePersistencePort.getUserBikesByUserId(userId);
    }

    @Override
    public Bike getBikeByBikeId(Long bikeId) {
        return bikePersistencePort.getBikeByBikeId(bikeId);
    }

    @Override
    public void saveBike(Bike bike) {
        bikePersistencePort.saveBike(bike);
    }
}
