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
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 식별자

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "age")
    private int age;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "sex")
    private String sex;

    @Enumerated(EnumType.STRING)
    private Role role;


    public Member

            (Long id,  String userName, String password, int age, LocalDate birthDate, String sex) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.birthDate = birthDate;
        this.sex = sex;
    }


    public Member() {

    }
}
