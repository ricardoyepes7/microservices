package com.tutorial.usermicroservice.application.handler.implementation;

import com.tutorial.usermicroservice.application.dto.UserDto;
import com.tutorial.usermicroservice.application.handler.interfaces.IBikeHandler;
import com.tutorial.usermicroservice.application.handler.interfaces.ICarHandler;
import com.tutorial.usermicroservice.application.handler.interfaces.IUserHandler;
import com.tutorial.usermicroservice.application.mapper.IUserDtoMapper;
import com.tutorial.usermicroservice.domain.api.IUserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserHandlerImp implements IUserHandler {
    private final IUserServicePort userServicePort;
    private final IUserDtoMapper userDtoMapper;
    private final ICarHandler carHandler;
    private final IBikeHandler bikeHandler;

    @Override
    public List<UserDto> getAllUsers() {
        return userServicePort.getAllUsers()
                .stream()
                .map(userDtoMapper::toDto)
                .toList();
    }

    @Override
    public UserDto getUserById(Long userId) {
        return userDtoMapper.toDto(userServicePort.getUserById(userId));
    }

    @Override
    @Transactional
    public void saveUser(UserDto userDto) {
        userServicePort.saveUser(userDtoMapper.toModel(userDto));
    }

    @Override
    public Map<String, Object> getAllVehiclesByUserId(Long userId) {
        userServicePort.getUserById(userId);
        Map<String, Object> map=new HashMap<>();
        map.put("Cars",carHandler.getAllCarsByUserId(userId));
        map.put("Bikes",bikeHandler.getAllBikesByUserId(userId));
        return map;
    }
}
