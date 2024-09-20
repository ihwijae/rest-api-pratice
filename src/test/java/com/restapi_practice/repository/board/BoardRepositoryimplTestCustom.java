package com.restapi_practice.repository.board;

import com.restapi_practice.domain.Board;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class BoardRepositoryimplTestCustom {

    @Autowired private BoardRepository boardRepository;

    @Test
    @Transactional
            public void boardsaveTest() {
        //given
        Board board = new Board();
        board.setBoardTitle("첫번쨰게시글");
        board.setBoardDetail("첫번째게시글내용입니다");

        //when
        Board save = boardRepository.save(board);
        Board findBoard = boardRepository.findById(board.getId()).orElseThrow();
        //then
        Assertions.assertThat(save).isEqualTo(findBoard);
    }


    @Test
    @Transactional
    public void boardUpdateTest() {
        //given
     BoardUpdateDto boardUpdateDto = new BoardUpdateDto();
     boardUpdateDto.setTitle("수정된제목");
     boardUpdateDto.setDetail("수정된디테일");
     //when
//        boardRepository.update(1L, boardUpdateDto);
    }


}