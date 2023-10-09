package com.tutorial.usermicroservice.domain.usecase;

import com.tutorial.usermicroservice.domain.api.IUserServicePort;
import com.tutorial.usermicroservice.domain.model.User;
import com.tutorial.usermicroservice.domain.spi.IUserPersistencePort;

import java.util.List;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public List<User> getAllUsers() {
        return userPersistencePort.getAllUsers();
    }

    @Override
    public User getUserById(long userId) {
        return userPersistencePort.getUserById(userId);
    }

    @Override
    public void saveUser(User user) {
        userPersistencePort.saveUser(user);
    }
}
