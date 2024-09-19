package com.restapi_practice.service.board;

import com.restapi_practice.repository.board.BoardSaveRsp;
import com.restapi_practice.repository.board.BoardUpdateDto;

public interface BoardService {

    public BoardSaveRsp save(BoardSaveReq boardSaveReq);


    public void update(BoardUpdateDto boardUpdateDto);

    public void delete(Long id);

}
