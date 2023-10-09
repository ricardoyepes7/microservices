package com.tutorial.usermicroservice.domain.usecase;

import com.tutorial.usermicroservice.domain.api.IBikeServicePort;
import com.tutorial.usermicroservice.domain.model.Bike;
import com.tutorial.usermicroservice.domain.spi.IBikePersistencePort;

import java.util.List;

public class BikeUseCase implements IBikeServicePort {
    private final IBikePersistencePort bikePersistencePort;

    public BikeUseCase(IBikePersistencePort bikePersistencePort) {
        this.bikePersistencePort = bikePersistencePort;
    }

    @Override
    public List<Bike> getAllBikesByUserId(Long userId) {
        return bikePersistencePort.getAllBikesByUserId(userId);
    }

    @Override
    public void saveBike(Bike bike) {
        bikePersistencePort.saveBike(bike);
    }
}
