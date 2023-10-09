package com.tutorial.usermicroservice.infrastructure.input.rest;

import com.tutorial.usermicroservice.application.dto.BikeDto;
import com.tutorial.usermicroservice.application.handler.interfaces.IBikeHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/bike")
@RequiredArgsConstructor
public class BikeController {
    private final IBikeHandler bikeHandler;

    @GetMapping("/{user_id}")
    public ResponseEntity<List<BikeDto>> getAllBikesByUserId(@PathVariable("user_id") Long userId) {
        return ResponseEntity.ok(bikeHandler.getAllBikesByUserId(userId));
    }

    @PostMapping("/{user_id}")
    public ResponseEntity<HttpStatus> saveUserBike(@RequestBody BikeDto bikeDto, @PathVariable("user_id") Long userId) {
        bikeHandler.saveUserBike(bikeDto, userId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
