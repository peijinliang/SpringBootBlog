package com.waylau.spring.boot.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.waylau.spring.boot.blog.domain.User;

/**
 * 用户服务接口.
 * 
 * @since 1.0.0 2017年5月29日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */

public interface UserService {

	 /**
     * 新增、编辑、保存用户
     * @param user
     * @return
     */
    User saveOrUpateUser(User user);

    /**
     * 注册用户
     * @param user
     * @return
     */
    User registerUser(User user);

    /**
     * 删除用户
     * @return
     */
    void removeUser(Long id);

    /**
     * 根据id获取用户
     * @return
     */
    User getUserById(Long id);

    /**
     * 根据用户名进行分页模糊查询
     * @return
     */
    Page<User> listUsersByNameLike(String name, Pageable pageable);
}