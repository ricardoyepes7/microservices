package com.tutorial.usermicroservice.feingclients;

import com.tutorial.usermicroservice.dto.BikeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "bike-service",path = "/bikes")
public interface BikeFeingClient {
    @GetMapping("/user/{userId}")
    List<BikeDto> getBikesByUserId(@PathVariable("userId") long userId);
    @PostMapping
    BikeDto saveBake(@RequestBody BikeDto bike);
}
