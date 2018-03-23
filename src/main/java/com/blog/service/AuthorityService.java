package com.blog.service;

import com.blog.domain.Authority;


/**
 * Authority 服务接口.
 *
 * @author Marlon
 * @since 1.0.0 2017年5月30日
 */

public interface AuthorityService {

    /**
     * 根据ID查询 Authority
     * @param id
     * @return
     */
    Authority getAuthorityById(Long id);


}
