package com.restapi_practice.apicontroller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardSearchRsp {

    private Long id;
    private String title;
    private String content;
}
