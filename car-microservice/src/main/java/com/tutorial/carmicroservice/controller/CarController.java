package com.tutorial.carmicroservice.controller;

import com.tutorial.carmicroservice.entity.Car;
import com.tutorial.carmicroservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> getAll(){
        return ResponseEntity.ok(carService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getUserById(@PathVariable("id") long id){
            return carService.getUserById(id)
                    .map(ResponseEntity::ok)
                    .orElseGet(()-> ResponseEntity.notFound().build());

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Car>> getByUserId(@PathVariable("userId") long userId){
        return ResponseEntity.ok(carService.getByUserId(userId));
    }
    @PostMapping
    public ResponseEntity<Car> saveUser(@RequestBody Car car){
        return new ResponseEntity<>(carService.save(car), HttpStatus.CREATED);
    }
}
