package com.restapi_practice.repository.board;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.restapi_practice.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CQRS 패턴
 * 참고로 spring data jpa 에는 자동으로 스프링 예외로 변환해주기 때문에 @Repository 안써도됨
 */
public interface BoardRepositoryV2 extends JpaRepository<Board, Long> {

}
