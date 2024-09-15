package com.restapi_practice.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jdk.jfr.Enabled;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 식별자

    @Column(name = "login_id")
    private String loginId; // 로그인 아이디

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "age")
    private int age;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "sex")
    private String sex;

    public User(Long id, String loginId, String userName, String password, int age, LocalDate birthDate, String sex) {
        this.id = id;
        this.loginId = loginId;
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.birthDate = birthDate;
        this.sex = sex;
    }

    public User() {

    }
}
