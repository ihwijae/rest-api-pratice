package com.restapi_practice.apicontroller;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Data
public class CreateUserRequest {

    @NotEmpty
    private String loginId;
    @NotEmpty
    private String username;
    @NotEmpty
private String password;





}
