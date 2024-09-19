package com.restapi_practice.apicontroller;

import com.restapi_practice.repository.board.BoardSaveRsp;
import com.restapi_practice.repository.board.BoardUpdateDto;
import com.restapi_practice.service.board.BoardSaveReq;
import com.restapi_practice.service.board.BoardService;
import com.restapi_practice.service.board.BoardUpdateRsp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
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
}
