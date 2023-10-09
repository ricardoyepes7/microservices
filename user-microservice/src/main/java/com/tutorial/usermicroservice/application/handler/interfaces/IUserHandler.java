package com.tutorial.usermicroservice.application.handler.interfaces;


import com.tutorial.usermicroservice.application.dto.UserDto;

import java.util.List;
import java.util.Map;

public interface IUserHandler {
    List<UserDto> getAllUsers();

    UserDto getUserById(Long userId);

    void saveUser(UserDto userDto);
    Map<String,Object> getAllVehiclesByUserId(Long userId);
}
