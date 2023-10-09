package com.tutorial.usermicroservice.domain.api;

import com.tutorial.usermicroservice.domain.model.User;

import java.util.List;

public interface IUserServicePort {
    List<User> getAllUsers();
    User getUserById(long userId);
    void saveUser(User user);
}
