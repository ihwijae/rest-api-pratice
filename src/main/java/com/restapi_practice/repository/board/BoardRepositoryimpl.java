package com.restapi_practice.repository.board;

import com.restapi_practice.domain.Board;
import com.restapi_practice.repository.user.SpringDataUserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BoardRepositoryimpl implements BoardRepository{

    private final SpringDataBoardJpaRepository springDataBoardJpaRepository;

    @Override
    public BoardSaveRsp save(Board board) {
        springDataBoardJpaRepository.save(board);
        BoardSaveRsp boardSaveRsp = new BoardSaveRsp();
        Long id = board.getId();
        boardSaveRsp.setSavdId(id);
        return boardSaveRsp;

    }

    @Override
    public void update(Long id, BoardUpdateDto updateParam) {
    }

    @Override
    public Optional<Board> findById(Long id) {
        return Optional.empty();
    }




}
