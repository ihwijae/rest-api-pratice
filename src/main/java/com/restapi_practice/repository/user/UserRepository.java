package com.restapi_practice.repository.user;

import com.restapi_practice.domain.User;

import java.util.List;
import java.util.Optional;


public interface UserRepository {


    public Long createUser (User user);

    public void updateUser (Long id, UserUpdateDto userUpdateDto);

    public Optional<User> findByUserId(Long id);

    public void deleteUser (Long id);

    public List<User> findAllUser(UserSearchAllDto userSearchAllDto);

}
