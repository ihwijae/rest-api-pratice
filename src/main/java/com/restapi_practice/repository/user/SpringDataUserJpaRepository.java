package com.restapi_practice.repository.user;

import com.restapi_practice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUserJpaRepository extends JpaRepository<User, Long> {



}
