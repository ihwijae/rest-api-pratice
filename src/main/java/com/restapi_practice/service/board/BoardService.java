package com.restapi_practice.service.board;

import com.restapi_practice.apicontroller.BoardSearchRsp;
import com.restapi_practice.repository.board.BoardSaveRsp;
import com.restapi_practice.repository.board.BoardSearchReq;
import com.restapi_practice.repository.board.BoardUpdateDto;

import java.util.List;

public interface BoardService {

    public BoardSaveRsp save(BoardSaveReq boardSaveReq);


    public BoardUpdateRsp update(Long id, BoardUpdateDto boardUpdateDto);

    public void delete(Long id);


    public List<BoardSearchRsp> search(BoardSearchReq requestParam);

    public List<BoardAllListRsp> allList();
}
