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
    @GeneratedValue(strategy = GenerationType.IDENTITY) //����������
    private Long id;  //�û���Ψһ��ʶ

    @Column(nullable = false) //ӳ��Ϊ�ֶΣ�ֵ����Ϊ��
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
