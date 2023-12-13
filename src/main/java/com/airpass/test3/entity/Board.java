package com.airpass.test3.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data // 룸복 - getter, setter 생성
public class Board {

    // 아래 어노테이션을 사용하면 JPA가 읽어들인다
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String content;
}
