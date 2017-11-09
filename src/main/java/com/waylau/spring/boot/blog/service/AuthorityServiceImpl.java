package com.waylau.spring.boot.blog.service;

import com.waylau.spring.boot.blog.domain.Authority;
import com.waylau.spring.boot.blog.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Crete by Marlon
 * Create Date: {DATE}
 * Class Describe
 **/

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public Authority getAuthorityById(Long id) {
        return authorityRepository.findOne(id);
    }




}
