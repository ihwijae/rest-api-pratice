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

        board.setBoardTitle(boardSaveReq.getTitle());
        board.setBoardDetail(boardSaveReq.getDetail());
        board.setBoardCreateDate(boardSaveReq.getBoardCreateDate());

        return boardRepository.save(board);
    }

    @Override
    public BoardUpdateRsp update(Long id, BoardUpdateDto boardUpdateDto) {
        Board findBoard = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Board id를 찾을 수 없습니다"));
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

    }
}
