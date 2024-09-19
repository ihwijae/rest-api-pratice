package com.restapi_practice.repository.board;

import com.restapi_practice.domain.Board;
import com.restapi_practice.service.board.BoardService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class BoardRepositoryimplTest {

    @Autowired private BoardRepository boardRepository;

    @Test
    @Transactional
    @Rollback(value = false)
            public void boardsaveTest() {
        //given
        Board board = new Board();
        board.setBoardTitle("첫번쨰게시글");
        board.setBoardDetail("첫번째게시글내용입니다");

        //when
       boardRepository.save(board);
       //then

    }


    @Test
    @Transactional
    @Rollback(value = false)
    public void boardUpdateTest() {
        //given
     BoardUpdateDto boardUpdateDto = new BoardUpdateDto();
     boardUpdateDto.setTitle("수정된제목");
     boardUpdateDto.setDetail("수정된디테일");
     //when
        boardRepository.update(1L, boardUpdateDto);


    }


}