package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.domain.Authority;

/**
 * Authority 仓库.
 * 
 * @since 1.0.0 2017年5月30日
 * @author Marlon
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long> {


}
