package com.restapi_practice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Board {



    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "board_title")
    private String boardTitle;

    @Column(name = "board_datail")
    private String boardDetail;

    @Column(name = "boaard_create_date")
    private LocalDateTime boardCreateDate;


}
