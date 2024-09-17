package com.restapi_practice.config;

import com.restapi_practice.repository.JpaUserRepository;
import com.restapi_practice.repository.UserRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfig {



    private final EntityManager em;


    public JpaConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public UserRepository userRepository() {
        return new JpaUserRepository(em);
    }
}
