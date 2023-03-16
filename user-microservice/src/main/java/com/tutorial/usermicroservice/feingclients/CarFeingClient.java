package com.tutorial.usermicroservice.feingclients;

import com.tutorial.usermicroservice.dto.BikeDto;
import com.tutorial.usermicroservice.dto.CarDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "car-service",url = "http://localhost:8002/car-service/cars")
public interface CarFeingClient {
    @GetMapping("/user/{userId}")
    List<CarDto> getCarsByUserId(@PathVariable("userId") long userId);
    @PostMapping
    CarDto saveCar(@RequestBody CarDto car);
}
