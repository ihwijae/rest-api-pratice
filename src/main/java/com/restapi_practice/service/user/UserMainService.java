package com.restapi_practice.service.user;

import com.restapi_practice.domain.User;
import com.restapi_practice.repository.user.UserRepository;
import com.restapi_practice.repository.user.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserMainService implements UserService{

    private UserRepository userRepository;

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
