package com.restapi_practice.service.board;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class BoardSaveReq {


    private Long id;


    private String title;


    private String detail;

    private LocalDateTime boardCreateDate;

}
