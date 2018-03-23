package com.blog.repository;

import com.blog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Comment Repository 接口.
 *
 * @author Marlon
 * @since 1.0.0 2017年6月6日
 */

public interface CommentRepository extends JpaRepository<Comment, Long> {


}
