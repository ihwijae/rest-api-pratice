package com.restapi_practice.repository.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardSearchReq {

    private String searchTitle;
    private String searchContent;
}
