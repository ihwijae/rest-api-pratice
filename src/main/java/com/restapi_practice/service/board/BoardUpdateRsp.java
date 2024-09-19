package com.restapi_practice.service.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardUpdateRsp {

    private Long id;
    private String title;
    private String detail;
}
