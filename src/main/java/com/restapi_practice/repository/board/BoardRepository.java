package com.restapi_practice.repository.board;

import com.restapi_practice.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 사용자 정의 메서드
 * QueryDSL이랑 SpringJdbcTemplate 또는 mybatis를 같이 사용할때 주로 사용한다.
 */
public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom {

}
