package com.tutorial.bikemicroservice.infrastructure.output.jpa.adapter;

import com.tutorial.bikemicroservice.domain.exception.BikeException;
import com.tutorial.bikemicroservice.domain.model.Bike;
import com.tutorial.bikemicroservice.domain.spi.IBikePersistencePort;
import com.tutorial.bikemicroservice.infrastructure.output.jpa.mapper.IBikeEntityMapper;
import com.tutorial.bikemicroservice.infrastructure.output.jpa.repository.IBikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@RequiredArgsConstructor
public class BikeJpaAdapter implements IBikePersistencePort {
    private final IBikeRepository bikeRepository;
    public final IBikeEntityMapper bikeEntityMapper;

    @Override
    public List<Bike> getAllBikes() {
        return bikeRepository.findAll()
                .stream()
                .map(bikeEntityMapper::toModel)
                .toList();
    }

    @Override
    public List<Bike> getUserBikesByUserId(Long userId) {
        return bikeRepository.findByUserId(userId)
                .stream()
                .map(bikeEntityMapper::toModel)
                .toList();
    }

    @Override
    public Bike getBikeByBikeId(Long bikeId) {
        return bikeRepository.findById(bikeId)
                .map(bikeEntityMapper::toModel)
                .orElseThrow(() -> new BikeException("Bike Not Found.",
                        "Moto con id: " + bikeId + " no encontrado.",
                        HttpStatus.NOT_FOUND));
    }

    @Override
    public void saveBike(Bike bike) {
        bikeRepository.save(bikeEntityMapper.toEntity(bike));
    }
}
