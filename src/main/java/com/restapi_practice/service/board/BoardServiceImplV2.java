package com.restapi_practice.service.board;

import com.restapi_practice.apicontroller.BoardSearchRsp;
import com.restapi_practice.domain.Board;
import com.restapi_practice.repository.board.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardServiceImplV2 implements BoardService {


    private final BoardRepositoryV2 repository;
    private final BoardQueryRepositoryV2 queryRepository;

    @Override
    public BoardSaveRsp save(BoardSaveReq boardSaveReq) {
        Board board = new Board();

        board.setBoardTitle(boardSaveReq.getTitle());
        board.setBoardDetail(boardSaveReq.getDetail());
        board.setBoardCreateDate(boardSaveReq.getBoardCreateDate());
        repository.save(board);

        BoardSaveRsp saveRsp = new BoardSaveRsp();
        saveRsp.setSavdId(board.getId());
        return saveRsp;
    }

    @Override
    public BoardUpdateRsp update(Long id, BoardUpdateDto boardUpdateDto) {
        Board findBoard = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Board id를 찾을 수 없습니다"));
        findBoard.setBoardTitle(boardUpdateDto.getTitle());
        findBoard.setBoardDetail(boardUpdateDto.getDetail());

        BoardUpdateRsp saveRsp = new BoardUpdateRsp();
        saveRsp.setId(findBoard.getId());
        saveRsp.setTitle(findBoard.getBoardTitle());
        saveRsp.setDetail(findBoard.getBoardDetail());
        return saveRsp;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }


    @Override
    public List<BoardSearchRsp> search(BoardSearchReq requestParam) {
        List<Board> result = queryRepository.findAll(requestParam);

        List<BoardSearchRsp> rsp = new ArrayList<>();

        for(Board board : result) {
            BoardSearchRsp boardSearchRsp = new BoardSearchRsp();
            boardSearchRsp.setId(board.getId());
            boardSearchRsp.setTitle(board.getBoardTitle());
            boardSearchRsp.setContent(board.getBoardDetail());
            rsp.add(boardSearchRsp);
        }
return rsp;
    }

    @Override
    public List<BoardAllListRsp> allList() {
        List<Board> all = repository.findAll();

        List<BoardAllListRsp> rsp = new ArrayList<>();

        for(Board board : all) {
            BoardAllListRsp boardAllListRsp = new BoardAllListRsp();
            boardAllListRsp.setId(board.getId());
            boardAllListRsp.setTitle(board.getBoardTitle());
            boardAllListRsp.setContent(board.getBoardDetail());
            rsp.add(boardAllListRsp);
        }
        return rsp;
    }
}
