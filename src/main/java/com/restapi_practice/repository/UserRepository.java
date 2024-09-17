package com.restapi_practice.repository;

import com.restapi_practice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Long, User>{

    public Long createUser (User user);

    public void updateUser (Long id, UserUpdateDto userUpdateDto);

    public Optional<User> findByUserId(Long id);

    public void deleteUser (Long id);

    public List<User> findAllUser(UserSearchAllDto userSearchAllDto);

}
