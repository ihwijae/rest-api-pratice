package com.restapi_practice.apicontroller;

import com.restapi_practice.repository.board.BoardSaveRsp;
import com.restapi_practice.repository.board.BoardSearchReq;
import com.restapi_practice.repository.board.BoardUpdateDto;
import com.restapi_practice.service.board.BoardAllListRsp;
import com.restapi_practice.service.board.BoardSaveReq;
import com.restapi_practice.service.board.BoardService;
import com.restapi_practice.service.board.BoardUpdateRsp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("/boards")
    @ResponseStatus(HttpStatus.CREATED)
    public BoardSaveRsp saveBoard(@RequestBody BoardSaveReq requestParam) {
        BoardSaveRsp save = boardService.save(requestParam);
        return save;
    }


    @PutMapping("/boards/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BoardUpdateRsp updateBoards(@PathVariable("id") Long id, @RequestBody BoardUpdateDto requestParam) {
        try {
            BoardUpdateRsp update = boardService.update(id, requestParam);
            return update;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/boards")
    public List<BoardSearchRsp> boardSearch(@ModelAttribute BoardSearchReq boardSearchReq){
        log.info(boardSearchReq.getSearchTitle());
        log.info(boardSearchReq.getSearchContent());
        List<BoardSearchRsp> search = boardService.search(boardSearchReq);
        return search;
    }

    @GetMapping("/boares")
    public List<BoardAllListRsp> boardAllList(){
        List<BoardAllListRsp> boardAllListRsps = boardService.allList();
        return boardAllListRsps;
    }

    
}
