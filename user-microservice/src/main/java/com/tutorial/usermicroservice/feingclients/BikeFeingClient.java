package com.tutorial.usermicroservice.feingclients;

import com.tutorial.usermicroservice.dto.BikeDto;
import com.tutorial.usermicroservice.dto.CarDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "bike-service",url = "http://localhost:8003/bike-service/bikes")
public interface BikeFeingClient {
    @GetMapping("/user/{userId}")
    List<BikeDto> getBikesByUserId(@PathVariable("userId") long userId);
    @PostMapping
    BikeDto saveBake(@RequestBody BikeDto bike);
}
