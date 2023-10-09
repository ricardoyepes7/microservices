package com.tutorial.carmicroservice.infrastructure.input.rest;

import com.tutorial.carmicroservice.application.dto.CarDto;
import com.tutorial.carmicroservice.application.handler.interfaces.ICarHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {
    private final ICarHandler carHandler;

    @GetMapping("/{carId}")
    public ResponseEntity<CarDto> getCarByCarId(@PathVariable("carId") Long carId) {
        return ResponseEntity.ok(carHandler.getCarByCarId(carId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CarDto>> getAllUserCars(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(carHandler.getAllUserCars(userId));
    }

    @PostMapping
    public ResponseEntity<HttpStatus> saveCar(@RequestBody CarDto carDto) {
        carHandler.saveCar(carDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
