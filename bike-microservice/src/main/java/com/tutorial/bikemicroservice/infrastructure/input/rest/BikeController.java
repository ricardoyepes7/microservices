package com.tutorial.bikemicroservice.infrastructure.input.rest;

import com.tutorial.bikemicroservice.application.dto.BikeDto;
import com.tutorial.bikemicroservice.application.handler.interfaces.IBikeHandler;
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

    @GetMapping()
    public ResponseEntity<List<BikeDto>> getAllBikes() {
        return ResponseEntity.ok(bikeHandler.getAllBikes());
    }

    @GetMapping("/{bikeId}")
    public ResponseEntity<BikeDto> getBikeByBikeId(@PathVariable("bikeId") Long bikeId) {
        return ResponseEntity.ok(bikeHandler.getBikeByBikeId(bikeId));
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BikeDto>> getUserBikesByUserId(@PathVariable("userId") Long userId){
        return ResponseEntity.ok(bikeHandler.getUserBikesByUserId(userId));
    }
    @PostMapping
    public ResponseEntity<HttpStatus> saveBike(@RequestBody BikeDto bikeDto){
        bikeHandler.saveBike(bikeDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
