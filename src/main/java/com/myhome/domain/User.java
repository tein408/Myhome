package com.myhome.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private Long uid;

    @Column(nullable = false, length = 100)
    private String id;

    @Column(nullable = false, length = 100)
    private String password;

    @ColumnDefault(value = "USER")
    @Enumerated(EnumType.STRING)
    private Role role;

    @CreationTimestamp
    private Timestamp joinDate;

}
