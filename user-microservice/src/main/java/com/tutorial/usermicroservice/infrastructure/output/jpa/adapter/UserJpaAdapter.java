package com.tutorial.usermicroservice.infrastructure.output.jpa.adapter;

import com.tutorial.usermicroservice.domain.exception.UserException;
import com.tutorial.usermicroservice.domain.model.User;
import com.tutorial.usermicroservice.domain.spi.IUserPersistencePort;
import com.tutorial.usermicroservice.infrastructure.output.jpa.mapper.IUserEntityMapper;
import com.tutorial.usermicroservice.infrastructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userEntityMapper::toModel)
                .toList();
    }

    @Override
    public User getUserById(long userId) {
        return userRepository.findById(userId)
                .map(userEntityMapper::toModel)
                .orElseThrow(() -> new UserException("User Not Found.",
                        "Usuario con id: " + userId + " no encontrado.",
                        HttpStatus.NOT_FOUND));
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(userEntityMapper.toEntity(user));
    }
}
