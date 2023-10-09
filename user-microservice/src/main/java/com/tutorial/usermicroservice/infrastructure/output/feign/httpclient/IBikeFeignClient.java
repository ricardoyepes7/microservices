package com.tutorial.usermicroservice.infrastructure.output.feign.httpclient;

import com.tutorial.usermicroservice.domain.exception.BikeException;
import com.tutorial.usermicroservice.infrastructure.output.feign.dto.BikeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "bike-service",path = "/bike")
public interface IBikeFeignClient {
    @GetMapping("/user/{userId}")
    List<BikeDto> getBikesByUserId(@PathVariable("userId") long userId) throws BikeException;
    @PostMapping
    BikeDto saveBike(@RequestBody BikeDto bike) throws BikeException;
}
