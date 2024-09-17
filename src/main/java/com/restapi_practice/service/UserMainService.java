package com.restapi_practice.service;

import com.restapi_practice.domain.User;
import com.restapi_practice.repository.UserUpdateDto;

import java.util.List;
import java.util.Optional;

public class UserMainService implements UserService{

    @Override
    public Long CreateUser(User user) {
        return null;
    }

    @Override
    public List<User> join() {
        return List.of();
    }

    @Override
    public Optional<User> findByUserId() {
        return Optional.empty();
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public void updateUser(Long id, UserUpdateDto userUpdateDto) {

    }
}
