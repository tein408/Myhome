package com.myhome.controller;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class UserForm {

    private Long id;
    private String password;
    private Date joinDate;

}
