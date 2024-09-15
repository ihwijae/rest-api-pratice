package com.restapi_practice.repository;

import lombok.Data;

import java.time.LocalDate;

// 유저의 정보를 변경할때 사용하는 DTO
@Data
public class UserUpdateDto {

    private LocalDate birth_date;
    private String userName;
    private String password;

    public UserUpdateDto(LocalDate birth_date, String userName, String password) {
        this.birth_date = birth_date;
        this.userName = userName;
        this.password = password;
    }
}
