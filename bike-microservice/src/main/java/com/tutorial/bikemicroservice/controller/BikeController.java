package com.tutorial.bikemicroservice.controller;

import com.tutorial.bikemicroservice.entity.Bike;
import com.tutorial.bikemicroservice.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bikes")
public class BikeController {
    @Autowired
    private BikeService bikeService;

    @GetMapping
    public ResponseEntity<List<Bike>> getAll(){
        return ResponseEntity.ok(bikeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bike> getUserById(@PathVariable("id") long id){
            return bikeService.getUserById(id)
                    .map(ResponseEntity::ok)
                    .orElseGet(()-> ResponseEntity.notFound().build());

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Bike>> getByUserId(@PathVariable("userId") long userId){
        return ResponseEntity.ok(bikeService.getByUserId(userId));
    }
    @PostMapping
    public ResponseEntity<Bike> saveUser(@RequestBody Bike bike){
        return new ResponseEntity<>(bikeService.save(bike), HttpStatus.CREATED);
    }
}
