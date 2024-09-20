package com.restapi_practice.repository.board;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
/**
 * 사용자 정의 메서드 구현체
 */
public class BoardRepositoryimpl implements BoardRepositoryCustom {

//    private final SpringDataBoardJpaRepository springDataBoardJpaRepository;

//    @Override
//    public List<BoardSearchRsp> search(BoardSearchReq boardSearchReq) {
//        return List.of();
//    }

//    @Override
//    public BoardSaveRsp save(Board board) {
//        springDataBoardJpaRepository.save(board);
//        BoardSaveRsp boardSaveRsp = new BoardSaveRsp();
//        Long id = board.getId();
//        boardSaveRsp.setSavdId(id);
//        return boardSaveRsp;
//
//    }

//    @Override
//    public void update(Long id, BoardUpdateDto updateParam) {
//        Board findBoard = springDataBoardJpaRepository.findById(id).orElseThrow();
//        findBoard.setBoardTitle(updateParam.getTitle());
//        findBoard.setBoardDetail(updateParam.getDetail());
//    }

//    @Override
//    public Optional<Board> findById(Long id) {
//        return springDataBoardJpaRepository.findById(id);
//    }




}
