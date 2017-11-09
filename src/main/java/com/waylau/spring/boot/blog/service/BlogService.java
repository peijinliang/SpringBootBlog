package com.waylau.spring.boot.blog.service;


import com.waylau.spring.boot.blog.domain.Blog;
import com.waylau.spring.boot.blog.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * ���ͽӿ�
 * Crete by Marlon
 * Create Date: {DATE}
 * Class Describe
 **/
public interface BlogService {

    Blog saveBlog(Blog blog);

    void removeBlog(Long id);

    Blog getBlogById(Long id);

    /**
     * ��ѯ�������Ʒ�ҳģ����ѯ�����£�
     * @param user
     * @param title
     * @param pageable
     * @return
     */
    Page<Blog> listBlogsByTitleVote(User user, String title, Pageable pageable);


    /**
     * ��ѯ�������Ʒ�ҳģ����ѯ�����ȣ�
     * @param user
     * @param title
     * @param pageable
     * @return
     */
    Page<Blog> listBlogsByTitleVoteAndSort(User user, String title, Pageable pageable);

    /**
     * �Ķ�������
     * @param id
     */
    void readingIncrease(Long id);


}
