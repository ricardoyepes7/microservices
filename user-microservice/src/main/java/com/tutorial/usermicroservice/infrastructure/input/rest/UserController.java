package com.tutorial.usermicroservice.infrastructure.input.rest;

import com.tutorial.usermicroservice.application.dto.UserDto;
import com.tutorial.usermicroservice.application.handler.interfaces.IUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final IUserHandler userHandler;
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userHandler.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("user_id") Long userId) {
        return ResponseEntity.ok(userHandler.getUserById(userId));
    }

    @PostMapping
    public ResponseEntity<HttpStatus> saveUser(@RequestBody UserDto userDto) {
        userHandler.saveUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/allVehicles/{user_id}")
    public ResponseEntity<Map<String, Object>> getAllVehiclesByUserId(@PathVariable("user_id") Long userId) {
        return ResponseEntity.ok(userHandler.getAllVehiclesByUserId(userId));
    }
}
