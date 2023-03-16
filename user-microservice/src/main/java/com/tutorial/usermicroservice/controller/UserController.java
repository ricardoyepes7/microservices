package com.tutorial.usermicroservice.controller;

import com.tutorial.usermicroservice.dto.BikeDto;
import com.tutorial.usermicroservice.dto.CarDto;
import com.tutorial.usermicroservice.entity.User;
import com.tutorial.usermicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping("/cars/{user_id}")
    public ResponseEntity<List<CarDto>> getCarsByUserId(@PathVariable("user_id") long userId) {
        return ResponseEntity.ok(userService.getCarsByUserId(userId));
    }
    @GetMapping("/bikes/{user_id}")
    public ResponseEntity<List<BikeDto>> getBikesByUserId(@PathVariable("user_id") long userId) {
        return ResponseEntity.ok(userService.getBikesByUserId(userId));
    }

    @GetMapping("/allVehicles/{user_id}")
    public ResponseEntity<Map<String, Object>> getAllVehiclesByUser(@PathVariable("user_id") long userId){
        try {
            return ResponseEntity.ok(userService.getAllVehiclesByUser(userId));
        }catch (Exception e){
            return  ResponseEntity.notFound().build();
        }

    }
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @PostMapping("/add-car/{user_id}")
    public ResponseEntity<CarDto> saveCar(@RequestBody CarDto car,@PathVariable("user_id") long userId){
        return new ResponseEntity<>(userService.saveCar(car,userId), HttpStatus.CREATED);
    }
    @PostMapping("/add-bike/{user_id}")
    public ResponseEntity<BikeDto> saveBike(@RequestBody BikeDto bike,@PathVariable("user_id") long userId){
        return new ResponseEntity<>(userService.saveBike(bike,userId), HttpStatus.CREATED);
    }
}
