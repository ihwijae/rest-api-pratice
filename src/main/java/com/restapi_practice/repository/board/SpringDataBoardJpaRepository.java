package com.restapi_practice.repository.board;

import com.restapi_practice.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataBoardJpaRepository extends JpaRepository<Board, Long> {
}
