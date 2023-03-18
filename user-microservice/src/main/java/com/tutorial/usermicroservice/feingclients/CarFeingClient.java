package com.tutorial.usermicroservice.feingclients;

import com.tutorial.usermicroservice.dto.CarDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "car-service", path = "/cars")
public interface CarFeingClient {
    @GetMapping("/user/{userId}")
    List<CarDto> getCarsByUserId(@PathVariable("userId") long userId);
    @PostMapping
    CarDto saveCar(@RequestBody CarDto car);
}
