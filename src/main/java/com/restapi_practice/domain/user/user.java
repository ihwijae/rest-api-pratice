package com.restapi_practice.domain.user;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class user {

    private Long id; // 식별자

    @NotEmpty
    private String loginId; // 로그인 아이디
    @NotEmpty
    private String name;
    @NotEmpty
    private String password;
}
