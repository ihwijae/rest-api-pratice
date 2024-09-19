package com.restapi_practice.service.user;

import com.restapi_practice.domain.User;
import com.restapi_practice.repository.user.UserUpdateDto;

import java.util.List;
import java.util.Optional;

public interface UserService {


    public Long CreateUser (User user);

    public List<User> join ();

    public Optional<User> findByUserId();

    public void deleteUser (Long id);

    public void updateUser (Long id, UserUpdateDto userUpdateDto);

}
