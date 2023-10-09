package com.tutorial.usermicroservice.domain.spi;

import com.tutorial.usermicroservice.domain.model.User;

import java.util.List;

public interface IUserPersistencePort {
    List<User> getAllUsers();
    User getUserById(long userId);
    void saveUser(User user);
}
