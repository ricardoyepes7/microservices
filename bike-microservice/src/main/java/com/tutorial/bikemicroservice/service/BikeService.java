package com.tutorial.bikemicroservice.service;

import com.tutorial.bikemicroservice.entity.Bike;
import com.tutorial.bikemicroservice.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikeService {
    @Autowired
    private BikeRepository bikeRepository;

    public List<Bike> getAll(){
        return bikeRepository.findAll();
    }

    public Optional<Bike> getUserById(long id){
        return bikeRepository.findById(id);
    }

    public Bike save(Bike bike){
        return bikeRepository.save(bike);
    }

    public List<Bike> getByUserId(long userId){
        return bikeRepository.findByUserId(userId);
    }
}
