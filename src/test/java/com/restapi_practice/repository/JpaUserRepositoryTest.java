package com.restapi_practice.repository;

import com.restapi_practice.config.JpaConfig;
import com.restapi_practice.domain.User;
import jakarta.annotation.security.RunAs;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import java.util.Optional;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class JpaUserRepositoryTest {

    @Autowired
    UserRepository userRepository;


    @Test
    @Transactional //테스트 케이스에 있으면 끝나고 바로 rollback() 실행해서 실제 db에 반영 xx
    @Rollback(value = false)
    public void testUser() throws Exception {
        //given
        User user = new User();
        user.setUserName("testUserkim");

        //when
        Long createId = userRepository.createUser(user);
        Optional<User> optionalUser = userRepository.findByUserId(createId);
        User findUser = optionalUser.get();


        //then
        Assertions.assertThat(findUser.getId()).isEqualTo(user.getId());
        Assertions.assertThat(findUser.getUserName()).isEqualTo(user.getUserName());
        Assertions.assertThat(findUser).isEqualTo(user); // 같은 트랜잭션 안에서 저장,조회 하면 영속성 컨텍스트가 동일함. 같은 영속성 안에서 같은 id로 조회하면 같은 엔티티로 식별
        // 같은 영속성 안에서는 식별자가 같으면 같은 엔티티.

    }

    @Test
    public void configTest () {
        ApplicationContext ac = new AnnotationConfigApplicationContext(JpaConfig.class);
        JpaConfig bean = ac.getBean(JpaConfig.class);

        System.out.printf("bean = " +  bean.getClass());
    }



}