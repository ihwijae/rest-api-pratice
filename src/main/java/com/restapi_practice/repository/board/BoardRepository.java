package com.restapi_practice.repository.board;

import com.restapi_practice.domain.Board;

import java.util.Optional;

public interface BoardRepository {



    public BoardSaveRsp save(Board board);

    public void update(Long id, BoardUpdateDto updateParam);

    public Optional<Board> findById(Long id);
}
