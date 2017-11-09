package com.waylau.spring.boot.blog.service;


import com.waylau.spring.boot.blog.domain.Blog;
import com.waylau.spring.boot.blog.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 博客接口
 * Crete by Marlon
 * Create Date: {DATE}
 * Class Describe
 **/
public interface BlogService {

    Blog saveBlog(Blog blog);

    void removeBlog(Long id);

    Blog getBlogById(Long id);

    /**
     * 查询博客名称分页模糊查询（最新）
     * @param user
     * @param title
     * @param pageable
     * @return
     */
    Page<Blog> listBlogsByTitleVote(User user, String title, Pageable pageable);


    /**
     * 查询博客名称分页模糊查询（最热）
     * @param user
     * @param title
     * @param pageable
     * @return
     */
    Page<Blog> listBlogsByTitleVoteAndSort(User user, String title, Pageable pageable);

    /**
     * 阅读量递增
     * @param id
     */
    void readingIncrease(Long id);


}
