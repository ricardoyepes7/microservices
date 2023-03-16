package com.tutorial.usermicroservice.service;

import com.tutorial.usermicroservice.dto.BikeDto;
import com.tutorial.usermicroservice.dto.CarDto;
import com.tutorial.usermicroservice.entity.User;
import com.tutorial.usermicroservice.feingclients.BikeFeingClient;
import com.tutorial.usermicroservice.feingclients.CarFeingClient;
import com.tutorial.usermicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CarFeingClient carFeingClient;
    @Autowired
    private BikeFeingClient bikeFeingClient;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<CarDto> getCarsByUserId(long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario con id: " + userId + " no encotrado"));
        return carFeingClient.getCarsByUserId(user.getId());
    }

    public List<BikeDto> getBikesByUserId(long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario con id: " + userId + " no encotrado"));
        return bikeFeingClient.getBikesByUserId(user.getId());
    }

    public CarDto saveCar(CarDto car, long userId) {
        car.setUserId(userId);
        return carFeingClient.saveCar(car);
    }

    public BikeDto saveBike(BikeDto bike, long userId) {
        bike.setUserId(userId);
        return bikeFeingClient.saveBake(bike);
    }

    public Map<String, Object> getAllVehiclesByUser(long userId) throws Exception{
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario con id: " + userId + " no encotrado"));
        Map<String, Object> map = new HashMap<>();
        map.put("Cars:", bikeFeingClient.getBikesByUserId(user.getId()));
        map.put("Bikes:",  carFeingClient.getCarsByUserId(user.getId()));
        return map;
    }
}
