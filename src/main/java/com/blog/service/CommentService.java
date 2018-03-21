package com.blog.service;


import com.blog.domain.Comment;

/**
 * Comment Service接口.
 * 
 * @since 1.0.0 2017年6月6日
 * @author Marlon
 */
public interface CommentService {

	/**
     * 根据id获取 Comment
     * @param id
     * @return
     */
    Comment getCommentById(Long id);
    /**
     * 删除评论
     * @param id
     * @return
     */
    void removeComment(Long id);
}
