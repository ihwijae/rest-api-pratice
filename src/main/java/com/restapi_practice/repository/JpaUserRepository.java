package com.restapi_practice.repository;

import com.restapi_practice.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class JpaUserRepository implements UserRepository {

    private final EntityManager entityManager; // 이게 바로 jpa 이 인터페이스를 토대로 저장하고, 조회하고, 수정하고..
    // 원래는 이거를 생성할때 데이터소스를 넣어주고, 엔티티매니저팩토리 란 것을 가지고 세팅을 해줘야 함.
    // 그런 과정을 스트링부트랑 통합을 해준다 (사용자가 주입받아서 사용하기만 하면 됨, 하지만 커스텀할때는 직접 세팅을 해줘야한다는것)

    public JpaUserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional // jpa의 모든 데이터 변경은 트랜잭션 안에서 이러우진다.
    public User save(User user) {
        entityManager.persist(user); // 마치 자바 컬렉션에 넣는것처럼 값을 꺼내서 다시 set으로 넣어주는 과정이 필요가 없다. (같은 참조)
        return user;
    }

    @Override
    @Transactional // jpa의 모든 데이터 변경은 트랜잭션 안에서 이러우진다.
    public void update(Long id, UserUpdateDto userUpdateDto) { // 이것도 자바 컬렉션과 비슷하다 컬렉션에서 객체를 꺼내와서 그 객체에 수정한 값을 다시 넣는것처럼..
        User findUser = entityManager.find(User.class, id);
        findUser.setUserName(userUpdateDto.getUserName());
        findUser.setPassword(userUpdateDto.getPassword());
        findUser.setBirthDate(userUpdateDto.getBirth_date());

        //여기까지하고 실제 수정을 저장하는 과정이 필요가없다.
        // jpa가 내부 매커니즘으로 (jpa가 조회 시점에 미리 스냅샷을 미리 떠놓고 어떤 데이터가 수정 됐는지 알고있다..)
        // 실제 트랜잭션이 commit 되는 시점에 db에 업데이트 쿼리를 보낸다.
        // 엔티티가 변경된 정보를 기반으로 업데이트 쿼리를 db에 보내는것이다!
        // 개발자는 자바 컬렉션에서 객체를 꺼내와서 값을 수정하는 것처럼만 한다.
        // 그럼 실제 db에 반영된다  언제? (내부에서 jap가 트랜잭션이 커밋되는 시점에 실제 db에 쿼리를 날리는것)
    }

    // 조회는 굳이 트랜잭션 할 필요 없을듯하다.
    @Override
    public Optional<User> findByUserId(Long id) {
        User user = entityManager.find(User.class, id); // 이것마치 자바컬렉션과 같은듯하다 컬렉션에서 id로 해당 인덱스에 있는 객체를 꺼내오는것처럼..
        return Optional.ofNullable(user);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<User> findAllUser(UserSearchAllDto userSearchAllDto) {

        return List.of();
    }
}
