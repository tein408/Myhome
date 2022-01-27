package com.myhome.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter @Setter
@Table(name = "Board05")
public class Board {

    @Id @GeneratedValue
    private Long id;

    private String title;

    private String content;

}
