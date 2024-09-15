package com.restapi_practice.repository;

import com.restapi_practice.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    public User save (User user);

    public void update (Long id, UserUpdateDto userUpdateDto);

    public Optional<User> findByUserId(Long id);

    public void delete (Long id);

    public List<User> findAllUser(UserSearchAllDto userSearchAllDto);
}
