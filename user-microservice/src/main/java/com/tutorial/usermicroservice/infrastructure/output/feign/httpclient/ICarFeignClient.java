package com.tutorial.usermicroservice.infrastructure.output.feign.httpclient;

import com.tutorial.usermicroservice.domain.exception.CarException;
import com.tutorial.usermicroservice.infrastructure.output.feign.dto.CarDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "car-service", path = "/car")
public interface ICarFeignClient {
    @GetMapping("/user/{userId}")
    List<CarDto> getCarsByUserId(@PathVariable("userId") long userId) throws CarException;
    @PostMapping
    CarDto saveCar(@RequestBody CarDto car)throws CarException;
}
