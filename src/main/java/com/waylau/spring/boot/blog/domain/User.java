package com.waylau.spring.boot.blog.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * User 实体.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017年4月29日
 */
@Entity // 实体
public class User implements UserDetails {

    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增策略
    private Long id; // 实体一个唯一标识

    @NotEmpty(message = "姓名不能为空")
    @Size(min = 2, max = 20)
    @Column(nullable = false, length = 20) // 映射为字段，值不能为空
    private String name;


    @NotEmpty(message = "邮箱不能为空")
    @Size(max = 50)
    @Email(message = "邮箱格式不对")
    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @NotEmpty(message = "账号不能为空")
    @Size(min = 3, max = 20)
    @Column(nullable = false, length = 20, unique = true)
    private String username; // 用户账号，用户登录时的唯一标识

    @NotEmpty(message = "密码不能为空")
    @Size(max = 100)
    @Column(length = 100)
    private String password; // 登录时密码

    @Column(length = 200)
    private String avatar; // 头像图片地址


    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorityList;

    protected User() {
        // 无参构造函数;设为 protected 防止直接使用
    }

    public User(Long id, String name, String username, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return String.format("User[id=%d,name='%s',username='%s',email='%s']", id, name, username, email);
    }

    public void setEncodePassword(String password) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode(password);
        this.password = encodePassword;
    }

    //账号是否过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //账号是否被锁
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //账号是否被认证过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //账号是否可用
    @Override
    public boolean isEnabled() {
        return true;
    }

    //其实我还是不太懂为什呢？ 主要是我对springSecurity不太了解api
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //需要将List<Authority> 转化成 List<SimpleGrantedAuthority>，否则前端拿不到角色列表名称
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (GrantedAuthority authority : this.authorityList) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }
        return simpleGrantedAuthorities;
    }


    public void setAuthorities(List<Authority> authorityList) {
        this.authorityList = authorityList;
    }




}
