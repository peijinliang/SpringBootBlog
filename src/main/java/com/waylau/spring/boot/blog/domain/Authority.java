package com.waylau.spring.boot.blog.domain;


import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;

/**
 * Crete by Marlon
 * Create Date: {DATE}
 * Class Describe
 **/
@Entity
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增长策略
    private Long id;  //用户的唯一标识

    @Column(nullable = false) //映射为字段，值不能为空
    private String name;


    @Override
    public String getAuthority() {
        return name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


}
