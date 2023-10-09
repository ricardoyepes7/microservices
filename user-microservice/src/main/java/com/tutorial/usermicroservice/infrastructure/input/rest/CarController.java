package com.tutorial.usermicroservice.infrastructure.input.rest;

import com.tutorial.usermicroservice.application.dto.CarDto;
import com.tutorial.usermicroservice.application.handler.interfaces.ICarHandler;
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
    @GetMapping("/{user_id}")
    public ResponseEntity<List<CarDto>> getAllCarsByUserId(@PathVariable("user_id") Long userId) {
        return ResponseEntity.ok(carHandler.getAllCarsByUserId(userId));
    }

    @PostMapping("/{user_id}")
    public ResponseEntity<HttpStatus> saveUserCar(@RequestBody CarDto carDto, @PathVariable("user_id") Long userId) {
        carHandler.saveUserCar(carDto, userId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
