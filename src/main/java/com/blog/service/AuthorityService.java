package com.blog.service;

import com.blog.domain.Authority;

/**
 * Authority 服务接口.
 * 
 * @since 1.0.0 2017年5月30日
 * @author Marlon
 */
public interface AuthorityService {
	/**
	 * 根据ID查询 Authority
	 * @param id
	 * @return
	 */
    Authority getAuthorityById(Long id);
}
