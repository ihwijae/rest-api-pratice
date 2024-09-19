package com.restapi_practice.service.board;

import com.restapi_practice.domain.Board;
import com.restapi_practice.repository.board.BoardRepository;
import com.restapi_practice.repository.board.BoardSaveRsp;
import com.restapi_practice.repository.board.BoardUpdateDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService {


    private final BoardRepository boardRepository;

    @Override
    public BoardSaveRsp save(BoardSaveReq boardSaveReq) {
        Board board = new Board();

        board.setBoardTitle(boardSaveReq.getBoardTitle());
        board.setBoardDetail(boardSaveReq.getBoardDetail());
        board.setBoardCreateDate(boardSaveReq.getBoardCreateDate());

        return boardRepository.save(board);
    }

    @Override
    public void update(BoardUpdateDto boardUpdateDto) {

    }

    @Override
    public void delete(Long id) {

    }
}
