package com.restapi_practice.service.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSignUpReq {

    @NotBlank(message = "이름을 입력하세요.")
    private String userName;

    @NotBlank(message = "이메일을 입력하세요")
    private String userEmail;

    @NotBlank(message = "패스워드를 입력하세요.")
    private String password;

    @NotBlank(message = "닉네임을 입력하세요.")
    @Size(min=2, message = "닉네임이 너무 짧습니다.")
    private String nickName;

    @NotBlank(message = "생일을 입력하세요.")
    private LocalDate birthDay;



}
